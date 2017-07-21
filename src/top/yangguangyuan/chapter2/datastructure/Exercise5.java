package top.yangguangyuan.chapter2.datastructure;

import java.util.Scanner;

/**
 * @ClassName: Exercise5 
 * @Description: TODO(树结构) 
 * @author yangguangyuan
 * @date 2017年7月20日 下午12:39:21 
 *
 */
public class Exercise5 {
	
}

class CBTType{
	String data;//元素数据
	CBTType left;//左树节点引用
	CBTType right;//右树节点引用
}

class P2_5{
	static final int MAXLEN=20;
	static Scanner input = new Scanner(System.in);
	
	/**
	 *初始化二叉树的根
	 */
	CBTType InitTree(){
		CBTType node;
		if((node=new CBTType())!=null){
			node.data = input.next();
			node.left = null;
			node.right = null;
			return node;
		}
		return null;
	}
	
	/**
	 * 添加节点
	 */
	void addTreeNode(CBTType treeNode){
		
	}
	
}