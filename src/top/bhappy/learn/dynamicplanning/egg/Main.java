package top.bhappy.learn.dynamicplanning.egg;

import top.bhappy.learn.dynamicplanning.egg.v1.DiGui;
import top.bhappy.learn.dynamicplanning.egg.v1.DiTui;

import java.util.Date;

/**
 * @Author: liu lei
 * @Date: 2020/4/5 13:35
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int eggNum = 5;
        int floorNum = 1000;
        long t1 = new Date().getTime();
        System.out.println(DiTui.getMinSteps(eggNum, floorNum));
        long t2 = new Date().getTime();
        System.out.println(DiGui.getMinSteps(eggNum, floorNum));
        long t3 = new Date().getTime();
        //System.out.println(DiGui.getCount());
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);

    }
}
