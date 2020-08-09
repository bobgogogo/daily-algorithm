import java.util.ArrayList;
import java.util.List;

public class Test0809 {

    List<String> ipList = new ArrayList<>();

    int size = -1;

    public List<String> restoreIpAddresses(String s) {
        size = s.length()+3;
        restoreIp("",s,0);
        return ipList;
    }

    public void restoreIp(String pre, String least, int step) {
        if (least.isEmpty()||least.length()>(4-step)*3){
            return;
        }
        if (step++<3) {
            int count = Math.min(least.length(),3);
            for (int i=1;i<=count;i++) {
                int ind = Integer.parseInt(least.substring(0, i));
                if (ind<=255) {
                    restoreIp(pre+'.'+ind,least.substring(i),step);
                }
            }
        } else {
            if (least.length()>3) {
                return;
            }
            int la = Integer.parseInt(least);
            if (la<=255) {
                String ip = (pre+'.'+la).substring(1);
                if (!ipList.contains(ip)&&ip.length()==size) {
                    ipList.add(ip);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "21111";
        Test0809 obj = new Test0809();
        List<String> strings = obj.restoreIpAddresses(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
