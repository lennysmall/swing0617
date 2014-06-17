package inner;
//로컬클래스는 다른곳에서 사용하기위해 만드는 경우가 많음
//로컬은 대부분 익명으로 사용
public class LocalClass {
	public static void main(String[] args) {
		//메소드안에서 클래스 선언
		class Local {
			public void showMe(){
				System.out.println("local class");
			}
			
		}
		Local local = new Local();
		local.showMe();
		
		//이게 obj로 들어가게됨
		test(new Local(){
			@Override
			public void showMe() {
				System.out.println("익명클래스");
			}@Override
			public String toString() {
			
				return "익명클래스";
			}
		});
	}
	public static void test(Object obj){
		System.out.println(obj);
	}
	
}
