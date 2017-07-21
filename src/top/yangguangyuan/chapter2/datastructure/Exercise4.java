package top.yangguangyuan.chapter2.datastructure;

import java.util.Scanner;


/**
 * @ClassName: Exercise4 
 * @Description: TODO(队列结构) 
 * @author yangguangyuan
 * @date 2017年7月13日 上午8:01:00 
 *
 */
public class Exercise4 {
	public static void main(String[] args) {
		SQType st = new SQType();
		DATA4 data1;
		
		Scanner input = new Scanner(System.in);
		SQType stack = st.SQTypeInit();
		System.out.println("入对列操作");
		System.out.println("输入 姓名 年龄 进行队列操作");
		do{
			DATA4 data = new DATA4();
			data.name = input.next();
			data.age = input.nextInt();
			if(data.name.equals("0")){
				break;
			}else{
				st.InSQType(stack, data);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("出对列,按任意非零键操作");
		temp = input.next();
		while (!temp.equals("0")) {
			data1 = st.OutSQType(stack);
			System.out.printf("出对列的数据是(%s,%d)",data1.name,data1.age);
			temp = input.next();
			
		}
		System.out.println("测试结束");
		st.SQTypeFree(stack);
	}
}

class DATA4{
	String name;
	int age;
}

class SQType{
	static final int QUEUELEN=15;
	DATA4[] data = new DATA4[QUEUELEN];
	int head;
	int tail;
	
	/**
	 * 初始化队列
	 */
	@SuppressWarnings("unused")
	SQType SQTypeInit(){
		SQType q;
		if((q=new SQType())!=null){
			q.head = 0;
			q.tail = 0;
			return q;
		}
		return null;
	}
	
	/**
	 * 判断空队列
	 */
	int SQTypeIsEmpty(SQType q){
		int temp = 0;
		if(q.head == q.tail){
			temp = 1;
		}
		return temp;
	}
	
	/**
	 *判断满队列 
	 */
	int SQTypeIsFull(SQType q){
		int temp=0;
		if(q.tail == QUEUELEN){
			tail = 1;
		}
		return tail;
	}
	
	/**
	 * 清空队列
	 */
	void SQTypeClear(SQType q){
		q.head = 0;
		q.tail = 0;
	}
	
	/**
	 * 释放空间
	 */
	void SQTypeFree(SQType q){
		if(q!=null){
			q=null;
		}
	}
	
	/**
	 * 入对列
	 */
	int InSQType(SQType q,DATA4 data){
		if(q.tail == QUEUELEN){
			System.out.println("对列已满,操作失败");
			return 0;
		}else{
			q.data[q.tail++]=data;
			return 1;
		}
	}
	
	/**
	 * 出对列
	 */
	DATA4 OutSQType(SQType q){
		if(q.head==q.tail){
			System.out.println("\n对列已空,操作失败");
			System.exit(0);
			return null;
		}
		return q.data[q.head++];
	}
	
	/**
	 * 读节点数据
	 */
	DATA4 PeekSQType(SQType q){
		if(SQTypeIsEmpty(q)==1){
			System.err.println("空队列");
			return null;
		}
		return q.data[q.head];
	}
	
	/**
	 * 计算队列的长度
	 */
	int SQTypeLen(SQType q){
		int temp;
		temp = q.tail - q.head;
		return temp;
	}
}