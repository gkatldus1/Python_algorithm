import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1541  {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> string = new LinkedList<>();
        String[] temp = br.readLine().split("-");//-를 기준으로 파싱
        for(int i=0; i<temp.length; i++){
            String[] temp2 = temp[i].split("\\+");  //+를 기준으로 파싱
            int sum = 0; 
            for(int j=0; j<temp2.length; j++){
                temp2[j].trim();    //양쪽 공백 제거
                sum += Integer.parseInt(temp2[j]);
            }
            string.offer(sum);  //-기준으로 파싱된 데이터들을 합해주고 큐에 넣어줌
            sum = 0;
        }
        int first = string.poll();
        int diff = 0;
        // while(!string.isEmpty()){   // 큐에서 처음 뺀 원소에서 나머지 원소들을 뺴줌
        //     diff = string.poll();
        //     first-= diff;
        // }
        // for(int i=0; i<string.size(); i++){
        //     diff = string.poll();
        //     first -= diff;
        // }
        Iterator itr = string.iterator();
        while(itr.hasNext()){
            diff = (int)itr.next();
            first -= diff;
        }


        System.out.println(first);
    }
}
