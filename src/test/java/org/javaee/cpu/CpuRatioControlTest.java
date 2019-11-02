package org.javaee.cpu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * CPU使用率控制
 *
 */
public class CpuRatioControlTest {

	@Test
	public void testCpuRatio10() {
		testControlCpuRatioByRunTime(10);
	}

	@Test
	public void testCpuRatio50() {
		testControlCpuRatioByRunTime(50);
	}
	
	@Test
	public void testCpuRatio80() {
		testControlCpuRatioByRunTime(80);
	}
	
	/**
	 * 通过控制运行时间和Sleep时间相同，来控制CPU的使用率。为防止锯齿，时间控制要合适，如运行和暂停10ms使用率为50%。
	 * 时间太大，锯齿比较大；时间太小，调度时间带来上下文切换，时间不稳定。
	 * 
	 * @param cpuRatio
	 */
	public void testControlCpuRatioByRunTime(int cpuRatio) {
		// 计算出100%的时间
		int totaltime = cpuRatio * 200000 + 10000000; // 粗略以10000000+10000000=20000000作为100%的时间，那么1%=20000000/100=200000
		// 计算出每次运行时间
		int runtime = totaltime * (cpuRatio / 100);
		// 计算出每次暂停时间
		int sleeptime = totaltime - runtime;
		
		int threads = Runtime.getRuntime().availableProcessors();
		for (int i = 0; i < threads; i++) {
			new Thread(new Runnable() {
				public void run() {
					long startTime = System.nanoTime();
					for (;;) {
						if (System.nanoTime() - startTime >= runtime) { // 运行runtime
							try {
								TimeUnit.NANOSECONDS.sleep(sleeptime); // 暂停sleeptime
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							startTime = System.nanoTime();
						}
					}
				}
			}).start();
		}
		
		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过执行空循环次数，来控制CPU的使用率。必须了解CPU的时钟周期和执行空循环
	 */
	@Test
	public void testControlCpuRatioByRunCount() {
		int threads = Runtime.getRuntime().availableProcessors();
		for (int i = 0; i < threads; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						for (int i = 0 ; i < 9600000; i++) { // 运行次数
						}
						try {
							TimeUnit.MILLISECONDS.sleep(10); // 暂停sleeptime
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		
		try {
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
