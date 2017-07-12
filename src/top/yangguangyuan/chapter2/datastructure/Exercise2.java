package top.yangguangyuan.chapter2.datastructure;

import java.util.Scanner;

/**
 * @ClassName: Exercise2
 * @Description: TODO(顺序表结构)
 * @author yangguangyuan
 * @date 2017年7月11日 下午12:45:36
 */
public class Exercise2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();
		String key;
		System.out.println("顺序表操作演示!!!");

		SL.SLInit(SL);
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("输入添加的节点(学号 姓名 年龄):");
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();

			if (data.age != 0) {
				if (SL.SLAdd(SL, data) == 0) {
					break;
				}

			} else {
				break;
			}
		} while (true);

		/**
		 * 显示所有节点
		 */
		System.out.println("顺序表中的节点顺序为:");
		SL.SLAll(SL);

		/**
		 * 查询
		 */
		System.out.println("要取出节点的序号:");
		i = input.nextInt();
		DATA data = SL.SLFindByNum(SL, i);
		if (data != null) {
			System.out.printf("第%d个节点为:(%s,%s,%d)\n", i, data.key, data.name,
					data.age);
		}

		/**
		 * 关键字查找
		 */
		System.out.print("\n要查找节点的关键字: ");
		key = input.next();
		i = SL.SLFindByCont(SL, key);
		data = SL.SLFindByNum(SL, i);
		if (data != null) {
			System.out.printf("第%d个节点为:(%s,%s,%d)\n", i, data.key, data.name,
					data.age);
		}

	}
}

class DATA {
	String key;
	String name;
	int age;
}

class SLType {
	static final int MAXLEN = 100;

	DATA[] ListDATA = new DATA[MAXLEN + 1];
	int ListLen;

	/**
	 * 初始化顺序表
	 */
	void SLInit(SLType SL) {
		SL.ListLen = 0;
	}

	/**
	 * 返回顺序表元素的数量
	 */
	int SLLength(SLType SL) {
		return SL.ListLen;
	}

	/**
	 * 插入节点
	 */
	int SLInsert(SLType SL, int n, DATA data) {
		int i;
		if (SL.ListLen >= MAXLEN) {
			System.out.println("顺序表已满,不能插入节点");
			return 0;
		}

		if (n < 1 || n > SL.ListLen - 1) {
			System.out.println("插入节点不正确!!");
			return 0;
		}

		for (i = SL.ListLen; i >= n; i--) {
			SL.ListDATA[i + 1] = SL.ListDATA[i];
		}

		SL.ListDATA[n] = data;
		SL.ListLen++;
		return 1;
	}

	/**
	 * 插入到尾部
	 */
	int SLAdd(SLType SL, DATA data) {
		if (SL.ListLen >= MAXLEN) {
			System.out.println("顺序表已满,不能再添加节点!!");
			return 0;
		}
		SL.ListDATA[++SL.ListLen] = data;
		return 1;
	}

	/**
	 * 删除顺序表中的数据元素
	 */
	int SLDelete(SLType SL, int n) {
		int i;
		if (n < 1 || n > SL.ListLen) {
			System.out.println("删除节点序号错误!");
			return 0;
		}

		for (i = n; i < SL.ListLen; i++) {
			SL.ListDATA[i] = SL.ListDATA[i + 1];
		}
		SL.ListLen--;
		return 1;
	}

	/**
	 * 根据序号返回数据元素
	 */
	DATA SLFindByNum(SLType SL, int n) {
		if (n < 1 || n > SL.ListLen + 1) {
			System.out.println("节点错误,不能返回节点!!!");
			return null;
		}
		return SL.ListDATA[n];
	}

	/**
	 * 按关键字查询节点
	 */
	int SLFindByCont(SLType SL, String key) {
		int i;
		for (i = 1; i <= SL.ListLen; i++) {
			if (SL.ListDATA[i].key.compareTo(key) == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 显示顺序表中的所有节点
	 */
	int SLAll(SLType SL) {
		int i;
		for (i = 1; i < SL.ListLen; i++) {
			System.out.println("(%s,%s,%d)\n," + SL.ListDATA[i].key + ","
					+ SL.ListDATA[i].name + "," + SL.ListDATA[i].age);
		}
		return 0;
	}
}