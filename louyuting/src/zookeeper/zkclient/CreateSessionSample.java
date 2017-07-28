package zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;

import javax.sound.midi.Soundbank;

/**
 * Created by louyuting on 2017/6/7.
 *
 * 使用 zkclient 来创建一个 Zookeeper客户端
 */
public class CreateSessionSample {

    public static void main(String[] args) {

        ZkClient zkClient = new ZkClient("123.206.13.151:2181", 5000);

        System.out.println("zookeeper session established");
    }



}
