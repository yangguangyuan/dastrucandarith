package top.yangguangyuan.chapter2.datastructure;

import java.util.Scanner;


/**
 * @ClassName: Exercise2
 * @Description: TODO(栈结构)
 * @author yangguangyuan
 * @date 2017年7月7日 下午6:00:55
 * 
 */
public class Exercise3 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		StackType st = new StackType();
		DATA3 data1 = new DATA3();
		
		StackType stack = st.STInit();
		Scanner input = new Scanner(System.in);
		System.out.println("入栈操作");
		System.out.println("输入姓名 年龄进行入栈");
		
		do{
			DATA3 data = new DATA3();
			data.name = input.next();
			if(data.name.equals("0")){
				break;
			}else{
				data.age=input.nextInt();
				st.PushST(stack, data);
			}
		}while(true);
		
		String temp="1";
		System.out.println("出栈操作:按任意非零键进行出栈操作");
		temp = input.next();
		while(!temp.equals("0")){
			data1 = st.PopST(stack);
			System.out.printf("出栈的数据是(%s,%d)\n",data1.name,data1.age);
			temp = input.next(); 
		}
		System.out.println("测试结束");
		st.STFree(st);
		
	}
}

/**
 * 数据
 */
class DATA3 {
	String name;
	int age;
}

class StackType {
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN + 1];
	int top;

	/**
	 * 初始化栈结构
	 */
	StackType STInit() {
		StackType p;
		if ((p = new StackType()) != null) {
			p.top = 0;
			return p;
		}
		return null;
	}

	/**
	 * 判断空栈
	 */
	boolean STIsEmpty(StackType s) {
		boolean t;
		t = (s.top == 0);
		return t;
	}

	/**
	 * 判断满栈
	 */
	boolean STIsFull(StackType s) {
		boolean t;
		t = (s.top == MAXLEN);
		return t;
	}

	/**
	 * 清空栈
	 */
	void STClear(StackType s) {
		s.top = 0;
	}

	/**
	 * 释放空间
	 */
	void STFree(StackType s){
		if(s!=null){
			s=null;
		}
	}
	
	/**
	 * 入栈
	 */
	int PushST(StackType s,DATA3 data){
		if((s.top+1)>MAXLEN){
			System.out.println("栈溢出!!");
			return 0;
		}
		
		s.data[++s.top]=data;
		return 1;
	}
	
	/**
	 * 出栈
	 */
	DATA3 PopST(StackType s){
		if(s.top==0){
			System.out.println("栈为空");
			System.exit(0);
		}
		return (s.data[s.top--]);
	}
	
	/**
	 * 读节点数据
	 */
	DATA3 PeekST(StackType s){
		if(s.top==0){
			System.out.println("栈为空!!");
			System.exit(0);
		}
		return (s.data[s.top]);
	}
	
}
