import java.util.Date;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class tokentest {
    static int count = 0;

    public static void showTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ++count;
                System.out.println("ʱ��=" + new Date() + " ִ����" + count + "��"); // 1��
            }
        };

        //����ִ��ʱ��
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//ÿ��
        //����ÿ���21:09:00ִ�У�
        calendar.set(year, month, day, 13, 21, 00);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        System.out.println(date);

        int period = 2 * 1000;
        //ÿ���dateʱ��ִ��task��ÿ��2���ظ�ִ��
        //timer.schedule(task, date, period);
        //ÿ���dateʱ��ִ��task, ��ִ��һ��
        timer.schedule(task, date);
    }

    public static void main(String[] args) {
        showTimer();
    }
}
