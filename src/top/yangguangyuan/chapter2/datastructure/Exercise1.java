package top.yangguangyuan.chapter2.datastructure;

import java.util.Date;
import java.util.Scanner;




/**
 * @ClassName: Exercise1
 * @Description: TODO(链表结构)
 * @author yangguangyuan
 * @date 2017年7月6日 下午7:16:49
 * 
 */
@SuppressWarnings("all")
public class Exercise1 {
	public static void main(String[] args) {
		CLType node,head = null;
		CLType CL=new CLType();
		String key,findkey;
		Scanner input = new Scanner(System.in);
		System.out.println("链表测试.先输入链表中的数据,格式为:关键字 姓名 年龄 \n");
		do{
			DATA2 nodeData = new DATA2();
			nodeData.key = input.next();
			if(nodeData.key.equals("0")){
				break;
			}else{
				nodeData.name = input.next();
			    nodeData.age = input.nextInt();
			    /**
			     * 尾部添加节点
			     */
			    head =  CL.CLAddEnd(head, nodeData);
			}
		}while(true);
		CL.CLAllNode(head);
		
		/**
		 * 插入节点
		 */
//		System.err.println("\n演示插入节点,输入插入位置的关键字: ");
//		findkey = input.next();
//		System.out.println("输入插入节点的数据(关键字 姓名 年龄):");
//		DATA2 nodeData = new DATA2();
//		nodeData.key = input.next();
//		nodeData.name= input.next();
//		nodeData.age = input.nextInt();
//		head = CL.CLInsertNode(head, findkey, nodeData);
//		CL.CLAllNode(head);
		
		/**
		 * 删除节点
		 */
//		System.out.println("\n演示删除节点,输入要删除的关键字");
//		key = input.next();
//		CL.CLDeleteNode(head, key);
//		CL.CLAllNode(head);
		
		/**
		 * 查找节点
		 */
		System.out.println("\n演示在链表中查找,输入查找的关键字:");
		key = input.next();
		node = CL.CLFindNode(head, key);
		if(node!=null){
			DATA2 nodeData = node.nodeData;
			System.err.println(nodeData.key+"/"+nodeData.name+"/"+nodeData.age);
			
		}else{
			System.out.println("未查询到关键字为"+key+"的节点");
		}
		
		
		
		
		
		
		
		
		
	}
}

/**
 * 数据
 */
class DATA2 {
	String key;
	String name;
	int age;
}

/**
 * 节点,一个节点包含(数据,下一个节点的引用)
 */
class CLType {
	DATA2 nodeData = new DATA2();// 数据
	CLType nextNode;// 下一个节点的引用

	/**
	 * 1.1追加节点
	 */
	CLType CLAddEnd(CLType head, DATA2 nodeData) {

		CLType node, htemp;

		if ((node = new CLType()) == null) {
			System.out.println("申请内存失败!");
			return null;
		} else {
			/**
			 * node是新建的节点
			 */
			node.nodeData = nodeData;
			node.nextNode = null;
			/*
			 * 如果头引用是空的,就将新建的节点返回去
			 */
			if (head == null) {
				head = node;
				return head;
			}

			htemp = head;
			while (htemp.nextNode != null) {
				htemp = htemp.nextNode;
			}

			htemp.nextNode = node;
			return head;
		}
	}

	/**
	 * 1.2插入头结点
	 */
	CLType CLAddFirst(CLType head, DATA2 nodeData) {
		CLType node;

		if ((node = new CLType()) == null) {
			System.out.println("申请内存失败!");
			return null;
		} else {
			node.nodeData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}

	/**
	 * 1.3查找节点
	 */
	CLType CLFindNode(CLType head, String key) {
		CLType htemp;
		htemp = head;

		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) {
				return htemp;
			}
			htemp = htemp.nextNode;
		}
		return null;
	}

	/**
	 * 1.4插入节点
	 */
	CLType CLInsertNode(CLType head, String findkey, DATA2 nodeDate) {
		CLType node, nodetemp;

		if ((node = new CLType()) == null) {
			System.out.println("申请内存失败!");
			return null;
		}

		node.nodeData = nodeDate;
		nodetemp = CLFindNode(head, findkey);

		if (nodetemp != null) {
			node.nextNode = nodetemp.nextNode;
			nodetemp.nextNode = node;
		} else {
			System.err.println("未找到正确的插入位置!!");
		}
		return head;
	}

	/**
	 * 1.5删除节点
	 */
	int CLDeleteNode(CLType head, String key) {
		CLType node, htemp;
		htemp = head;
		node = head;

		while (htemp != null) {
			if ((htemp.nodeData.key.compareTo(key)) == 0) {
				node.nextNode = htemp.nextNode;
				htemp = null;
				return 1;
			} else {
				node = htemp;
				htemp = htemp.nextNode;
			}
		}
		return 0;
	}

	/**
	 * 1.6计算链表长度
	 */
	int CLLength(CLType head) {
		CLType htemp;
		int Len = 0;
		htemp = head;
		while (htemp != null) {
			Len++;
			htemp = htemp.nextNode;
		}
		return Len;
	}

	/**
	 * 显示所有节点
	 */
	void CLAllNode(CLType head) {
		CLType htemp;
		DATA2 nodeDate;
		htemp = head;
		System.out.println("当前链表共有%d个节点.链表所有数据如下:\n" + CLLength(head));
		while (htemp != null) {
			nodeDate = htemp.nodeData;
			System.out.println("节点(%s,%s,%d)\n:" + nodeDate.key + ","
					+ nodeDate.name + "," + nodeDate.age);
			htemp = htemp.nextNode;
		}
	}
}
