package inner;

public class OuterClass {
	final int a=10;
	
	//이너클래스는 static 클래스라고 적을수 있음. 그냥은 안됨
	//외부에서 참조되지 않게 사용가능
	public class InnerClass{
		//필드변수 생성 가능
		String name = "inner";
		//동일하게 생성자도 가질수 있음
		public InnerClass(){
			System.out.println("Inner Class 생성됨");
		}
		//메소드 생성
		public void showMe(){
			//이너클래스는 필드변수 다써짐 int a, 
			System.out.println("이게나야!쇼미!"+name+a);
		}
	}
	
	//이너 static 클래스는 아우터 클래스 자원 사용 불가. static만 접근가능
	//int a 사용 불가
	public static class StaticInner{
		public void showMe(){
			System.out.println("static inner");
		}
	}
	
	public void innerTest(){
		//이너클래스 안에서는 outer안쓰고 그냥 바로 써도 됨
		InnerClass inner = new InnerClass();
		inner.showMe();
	}
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		//바깥클래스를 통해서 안쪽(inner)클래스를 생성
		//이너클래스는 객체를 통해서만 접근가능
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.showMe();
		outer.innerTest();
		OuterClass.StaticInner staticInner = new OuterClass.StaticInner();
		staticInner.showMe();

	}

}
