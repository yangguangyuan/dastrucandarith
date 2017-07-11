package top.yangguangyuan.chapter2.datastructure;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @ClassName: Exercise2
 * @Description: TODO(顺序表结构)
 * @author yangguangyuan
 * @date 2017年7月11日 下午12:45:36
 */
public class Exercise2 {

}

class DATA {
	String key;
	String name;
	String age;
}

class SLType {
	static final int MAXLEN = 100;

	DATA[] ListDATA = new DATA[MAXLEN+1];
	int ListLen;
	
	/**
	 * 初始化顺序表
	 */
	void SLInit(SLType SL){
		SL.ListLen = 0;
	}
	
	/**
	 * 返回顺序表元素的数量
	 */
	int SLLength(SLType SL){
		return SL.ListLen;
	}
	
	/**
	 * 插入节点
	 */
	int SLInsert(SLType SL,int n,DATA data){
		int i;
		if(SL.ListLen>=MAXLEN){
			System.out.println("顺序表已满,不能插入节点");
			return 0;
		}
		
		if(n<1||n>SL.ListLen-1){
			System.out.println("插入节点不正确!!");
			return 0;
		}
		
		for(i=SL.ListLen;i>=n;i--){
			SL.ListDATA[i+1] = SL.ListDATA[i];
		}
		
		SL.ListDATA[n] = data;
		SL.ListLen++;
		return 1;
	}
	
	/**
	 * 插入到尾部
	 */
	int SLAdd(SLType SL,DATA data){
		if(SL.ListLen>=MAXLEN){
			System.out.println("顺序表已满,不能再添加节点!!");
			return 0;
		}
		SL.ListDATA[++SL.ListLen] = data;
		return 1;
	}
	
	
}