package synch2;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/11/27
 *  Last updated:  2018/11/27
 *  Compilation:   javac testThread.java
 *  Description: 
 *
 ******************************************************************************/





import com.sun.istack.internal.NotNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;

    /**
     * @auther shijx
     * @description 类描述
     * @date 2018/11/27
     */
    public class testThread {
        public LinkedBlockingQueue<String> que = new LinkedBlockingQueue<>();
        public void mainWayImitate() {
            que.add("1");
            que.add("2");
            que.add("3");
            //执行一个线程 消费队列
            new Thread(() -> {
                while (true) {
                    if (que.size() > 0) {
                        String poll = que.poll();
                        testThread testMain = new testThread();
                        System.out.println("队列中取出了" + poll);
                        if(testMain.testMainProcess(poll)){
                            System.out.println("下一个.");
                        }
                    }
                }
            }).start();
        }

        public boolean testMainProcess(String str) {
            try {
                System.out.println("方法:" + str);
                final CountDownLatch contDownLatch = new CountDownLatch(3);//使用java并发库
                for (int i = 0; i < 3; i++) {
                    Worker thread = new Worker("线程-" + i, contDownLatch);
                    thread.start();
                }
                contDownLatch.await();
                System.out.println("方法:"+str+"完毕,返回");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }


        protected class Worker extends Thread {
            private CountDownLatch latch;
            private String nameThread;

            //latch java并发库用于执行 在多线程完毕后执行的方法
            public Worker(@NotNull String name, CountDownLatch latch) {
                this.nameThread = name;
                this.latch = latch;
            }

            public void run() {
                System.out.println("进入线程...");
                for (int j = 0; j < 10; j++) {
                    System.out.println("print" + nameThread + j);
                    latch.countDown();
                }
            }
        }


    public static void main(String[] args) {
        testThread testThread1 = new testThread();
        testThread1.mainWayImitate();
    }
}
