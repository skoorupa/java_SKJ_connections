import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ClientTCP_KOLOS {
    public static void main(String[] args) throws IOException {
        Socket connection = new Socket("172.21.40.125",10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));


//      //////////////////////////////
//      odbieranie haseł + zadań

//        bw.write("s29441 s29441");
//        bw.newLine();
//        bw.flush();
//
//        String response = "";
//        while ((response = br.readLine()) != null) {
//            System.out.println(response);
//        }

//      //////////////////////////////
//      rozwiązywanie zadań

        bw.write("s29441 wRxRuLsnQF");
        bw.newLine();
        bw.flush();

        { // 1
            System.out.println("#1");
            String nums = br.readLine();
            nums = nums.replaceAll(" ","");
            bw.write(nums);
            bw.newLine();
            bw.flush();
            System.out.println("C: "+nums);
            System.out.println("S: "+br.readLine());
        }
        { // 2
            System.out.println("#2");
            String nums = "";
            nums+=(Integer.parseInt(br.readLine()));
            nums+=(Integer.parseInt(br.readLine()));
            nums+=(Integer.parseInt(br.readLine()));
            nums+=(Integer.parseInt(br.readLine()));
            bw.write(nums);
            bw.newLine();
            bw.flush();
            System.out.println("C: "+nums);
            System.out.println("S: "+br.readLine());
        }
        { // 3
            System.out.println("#3");
            String r1 = (br.readLine()+br.readLine());
            String r2 = (br.readLine()+br.readLine());
            String r3 = (br.readLine()+br.readLine());
            String r4 = (br.readLine()+br.readLine());
            bw.write(r1);
            bw.newLine();
            bw.write(r2);
            bw.newLine();
            bw.write(r3);
            bw.newLine();
            bw.write(r4);
            bw.newLine();
            bw.flush();
//            System.out.println("C: "+nums);
            System.out.println("S: "+br.readLine());
        }
        { // 4
            System.out.println("#4");
            int K = Integer.parseInt(br.readLine());
            System.out.println("K: "+K);
            int K2 = K*2;
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                res.add(br.readLine());
            }
            for (int i = 0; i < K; i++) {
                bw.write(res.get(i)+br.readLine());
                bw.newLine();
                bw.flush();
            }
            System.out.println("S: "+br.readLine());
        }
        { // 5 - NIE DZIAŁA
            System.out.println("#5");
            int K2 = 0;
            ArrayList<String> liczby = new ArrayList<>();
            String liczba = "";
            Date dnow = new Date();
            Date dlast = new Date();
            while ((new Date()).getTime() - dlast.getTime()<2000) {
                liczba = br.readLine();
                liczby.add(liczba);
                K2++;
                System.out.println(K2+": "+liczba);
                dlast = new Date();
            }
            System.out.println("wyjscie z 1 petli");
            // liczba jaka dostalismy to K+1 liczba
            K2--;
            bw.write(liczby.get(0)+ liczba);
            bw.flush();
            for (int i = 1; i < K2/2; i++) {
                bw.write(liczby.get(i)+ br.readLine());
                bw.flush();
            }
            System.out.println("S: "+br.readLine());
        }

        connection.close();
    }
}
