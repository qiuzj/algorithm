package org.javaee.heap.example;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.javaee.heap.MinGenericHeap;
import org.junit.Test;

/**
 * 实战2：高性能定时器
 * 
 */
public class HighPerformanceSchedulerTest {

	private static final int ONE_SECONDS_NANOS_1_000_000_000 = 1_000_000_000;

	@Test
	public void testScheduler() {
		MinGenericHeap<Task> heap = new MinGenericHeap<>();
		
		// 消费任务的线程
		Thread consumerThread = new Thread() {
			@Override
			public void run() {
				// 这里只是为了测试，看看LockSupport.unpark有没有效果
				HighPerformanceSchedulerTest.this.sleep(ONE_SECONDS_NANOS_1_000_000_000);

				Task task = null;
				while (true) {
					// 1.获取堆顶任务
					task = heap.peek();
					
					long timeToWait = ONE_SECONDS_NANOS_1_000_000_000;
					// 2.如果没有任务，或没到任务执行时间，则进行等待
					if (task == null || (timeToWait = task.getExecTime() - System.nanoTime()) > 0) {
						LockSupport.parkNanos(timeToWait);
					// 3.时间到了，则立即执行任务
					} else {
						task = heap.removeTop();
						System.out.println(String.format("Running task: %s, nowTime: %s, %s",
								task.toString(), System.nanoTime(), new Date()));
					}
				}
			}
		};
		consumerThread.start();
		
		// 生产任务的线程
		new Thread() {
			@Override
			public void run() {
				Random random = new Random();
				System.out.println(new Date());
				for (int i = 0; i < 5; i++) {
					String taskName = "Task" + i;
					long waitSecs = random.nextInt(5) + 2;
					
					// 这里只是为了测试，看看LockSupport.unpark有没有效果
					if (i == 0) {
						waitSecs = 10;
					}
					
					long waitNanos = TimeUnit.NANOSECONDS.convert(waitSecs, TimeUnit.SECONDS);
					long execTime = System.nanoTime() + waitNanos;
					System.out.println(String.format("add task: %s, execTime: %s, waitSecs: %s s, timeToExec: %s",
							taskName, execTime, waitSecs, new Date(System.currentTimeMillis() + waitSecs * 1000)));
					// 1.将任务插入小顶堆
					heap.insert(new Task(taskName, execTime));
					
					// 2.唤醒消息线程
					LockSupport.unpark(consumerThread);
					
					
					// 这里只是为了测试，看看LockSupport.unpark有没有效果
					if (i == 0) {
						HighPerformanceSchedulerTest.this.sleep(2 * ONE_SECONDS_NANOS_1_000_000_000);
					}
				}
			}
		}.start();
		
		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 任务
	 *
	 */
	class Task implements Comparable<Object>{
		private String taskName;
		private long execTime;
		public Task(String taskName, long execTime) {
			this.taskName = taskName;
			this.execTime = execTime;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public long getExecTime() {
			return execTime;
		}
		public void setExecTime(long execTime) {
			this.execTime = execTime;
		}
		@Override
		public int compareTo(Object o) {
			if (this == o) {
				return 0;
			}
			return execTime >= ((Task) o).getExecTime() ? 1 : -1;
		}
		@Override
		public String toString() {
			return "Task [taskName=" + taskName + ", execTime=" + execTime + "]";
		}
	}

	private void sleep(long nanos) {
		try {
			TimeUnit.NANOSECONDS.sleep(nanos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
