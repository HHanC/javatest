import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class java {

        //1. 메뉴 [카페인, 논카페인, 디저트]
        // 카페인: 아메리카노(1000), 카페라떼(1500), 카페모카(1700)
        // 논카페인: 디카페인 아메리카노(1000), 레몬에이드(1500), 밀크쉐이크(2000)
        // 디저트: 쿠키(500), 치즈케이크(1000), 크로플(800)
        //2. 주문 받기
        //3. 계산
        //4.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 읽기 위한 스캐너
        ArrayList<String> 음료 = new ArrayList<>(Arrays.asList("아메리카노","카페라떼",
                "디카페인 아메리카노","레몬에이드","밀크쉐이크","쿠키", "크로플"));
        //메뉴를 선언한다. (재고는 따로  없음)
        int 아메리카노구매수 = 0; int 카페라떼구매수 = 0; int 디카페인구매수 = 0;
        int 레몬에이드구매수 = 0; int 밀크구매수 = 0; int 쿠키구매수 = 0; int 크로플구매수 = 0;
        //재고가 없는 대신에 구매수를 체크하여 장바구니를 만든다.

        while (true) { //가장 먼저 메뉴를 선언한다.
            System.out.println("----------------- 메뉴 -----------------");
            System.out.println("메뉴를 선택해주세요.");
            System.out.println("1.카페인 2.논카페인 3.디저트 4.결제"); int ch = scanner.nextInt();
            //선택지를 나열하고 선택을 입력받아 저장한다.

            //각 선택에 따른 선택지. 구매하면 구매수가 하나씩 올라간다.
            if (ch==1) { //카페인 메뉴를 선택
                System.out.println("1.아메리카노(1000), 2.카페라떼(1000)");
                int ch1 = scanner.nextInt();
                if(ch1==1) { System.out.println("아메리카노를 한 잔 담았습니다."); 아메리카노구매수++;}
                else if(ch1==2) { System.out.println("카페라떼를 한 잔 담았습니다."); 카페라떼구매수++;}

            } else if (ch==2) {   //디카페인 메뉴를 선택
                System.out.println("1.디카페인 아메리카노(1200), 2.레몬에이드(1200), 3.밀크쉐이크(1200)");
                int ch2 = scanner.nextInt();
                if(ch2==1) { System.out.println("디카페인 아메리카노를 한 잔 담았습니다."); 디카페인구매수++;}
                else if(ch2==2) { System.out.println("레몬에이드를 한 잔 담았습니다."); 레몬에이드구매수++;}
                else if(ch2==3) {System.out.println("밀크쉐이크를 한 잔 담았습니다."); 밀크구매수++;}

            } else if (ch==3) {   //디저트를 선택
                System.out.println("1.쿠키(500) 2.치즈케이크(500) 3.크로플(500)");
                int ch3 = scanner.nextInt();
                if(ch3==1) { System.out.println("쿠키를 하나 담았습니다."); 쿠키구매수++;}
                else if(ch3==2) { System.out.println("크로플을 하나 담았습니다."); 크로플구매수++;}

            } else if (ch==4) { //장바구니를 만든다.
                System.out.println("-----------------장바구니-----------------");
                System.out.println("제품명\t수량\t금액");
                if(아메리카노구매수 !=0) System.out.println("아메리카노\t"+아메리카노구매수+"\t"+(아메리카노구매수*1000));
                if(카페라떼구매수 !=0) System.out.println("카페라떼\t"+카페라떼구매수+"\t"+(카페라떼구매수*1000));
                if(디카페인구매수 !=0) System.out.println("디카페인 아메리카노\t"+디카페인구매수+"\t"+(디카페인구매수*1200));
                if(레몬에이드구매수 !=0) System.out.println("레몬에이드\t"+레몬에이드구매수+"\t"+(레몬에이드구매수*1200));
                if(밀크구매수 !=0) System.out.println("밀크쉐이크\t"+밀크구매수+"\t"+(밀크구매수*1200));
                if(쿠키구매수 !=0) System.out.println("쿠키\t"+쿠키구매수+"\t"+(쿠키구매수*500));
                if(크로플구매수 !=0) System.out.println("크로플\t"+크로플구매수+"\t"+(크로플구매수*500));

                //총결제액을 만든다.
                int 총결제액 = (아메리카노구매수*1000)+(카페라떼구매수*1000)+(디카페인구매수*1200)+(레몬에이드구매수*1200)+
                        (밀크구매수*1200)+(쿠키구매수*500)+(크로플구매수*500) ;

                System.out.println("제품 총 결제액 : " + 총결제액 );
                System.out.println("--------------------------------------");
                System.out.println("1. 결제 2. 취소");
                int ch4 = scanner.nextInt();

                if( ch4 == 1 ) { while(true) {  System.out.println("알림) 입금 금액 : "); int 금액 = scanner.nextInt();
                    if(금액<총결제액) { System.err.println("알림) 금액이 부족합니다. 다시 투여해주세요.");}
                    //넣은 금액이 결제액보다 적을 경우 에러메세지 송출. 그렇지 않으면 결제 성공
                    else { System.err.println("알림) 결제 성공! 구매가 완료되었습니다.");}
                    //결제 성공 후 구매수는 0으로 되돌린다.
                    아메리카노구매수 = 0; 카페라떼구매수 = 0;디카페인구매수 = 0;
                    레몬에이드구매수 = 0; 밀크구매수 = 0; 쿠키구매수 = 0; 크로플구매수 = 0;
                    System.out.println("알림) 잔돈 : " + (금액 - 총결제액)+"원" ); break; } }
                //결제가 완료되면 break를 사용하고 빠져나가 가장 위의 while로 돌아간다.

            } else { System.out.println("잘못된 번호를 입력하였습니다.");}
        }



////////////////////////////////////////////////
    }
}
