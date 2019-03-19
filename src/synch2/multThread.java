package synch2;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/12/3
 *  Last updated:  2018/12/3
 *  Compilation:   javac multThread.java
 *  Description: 
 *
 ******************************************************************************/


public class multThread {

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            dataList.add(i);
        }
        WordThread[] workThreadArray = new WordThread[4];
        System.out.println("all dataList: " + dataList);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < workThreadArray.length; ++i)
        {
            workThreadArray[i] = new WordThread("线程" + i, dataList.subList(i * 3, (i + 1) * 3));
            workThreadArray[i].start();
        }
        for (WordThread aWorkThread : workThreadArray)
        {
            try
            {
                aWorkThread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }


    static class WordThread extends Thread {
        private List<Integer> wordDataList;

        WordThread(String name, List<Integer> wordDataList) {
            super(name);
            this.wordDataList = wordDataList;
        }

        @Override
        public void run() {
            System.out.println(getName() + "start Process" + wordDataList);

            for(int i = 0; i < wordDataList.size(); ++i) {
                wordDataList.set(i, wordDataList.get(i) + 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            System.out.println(getName() + "处理完毕" + wordDataList);
        }

        public List<Integer> getResult() {
            return wordDataList;
        }

    }
}
