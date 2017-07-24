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
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		CBTType root = null;
		int menusel;
		P2_5 p = new P2_5();
		root = p.InitTree();
		
		/**
		 * 添加节点
		 */
		do{
			System.out.printf("请选择菜单,添加二叉树的节点\n");
			System.out.printf("0.退出\t");
			System.out.printf("1.添加二叉树的节点\n");
			menusel = input.nextInt();
			switch (menusel) {
			case 1:
				p.addTreeNode(root);
				break;
			case 0:
				break;
			default:
				break;
			}
			
		}while(menusel!=0);
		
		/**
		 *遍历 
		 */
		do{
			System.out.println("请选择菜单遍历二叉树");
			System.out.println("1.先序遍历");
			System.out.println("2.中序遍历");
			System.out.println("3.后序遍历");
			System.out.println("4.按层遍历");
			
			menusel = input.nextInt();
			
			switch (menusel) {
			case 1:
				System.out.println("先序遍历");
				p.DLRTree(root);
				System.out.printf("/n");
				break;
				
			case 2:
				System.out.println("中序遍历");
				p.LDRTree(root);
				System.out.printf("/n");
				break;
				
			case 3:
				System.out.println("后序遍历");
				p.LRDTree(root);
				System.out.printf("/n");
				break;
			
			case 4:
				System.out.println("按层遍历");
				p.LevelTree(root);
				System.out.printf("\n");
			default:
				break;
			}
			
		}while(menusel!=0);
		
		System.out.println("二叉树的深度为:"+p.TreeDepth(root));
		p.ClearTree(root);
		root = null;
	}
}

class CBTType {
	String data;// 元素数据
	CBTType left;// 左树节点引用
	CBTType right;// 右树节点引用
}

class P2_5 {
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);

	/**
	 * 初始化二叉树的根
	 */
	CBTType InitTree() {
		CBTType node;
		if ((node = new CBTType()) != null) {
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
	void addTreeNode(CBTType treeNode) {
		CBTType pnode, parent;
		String data;
		int menusel;

		if ((pnode = new CBTType()) != null) {
			System.out.println("输入二叉树的节点数据");
			pnode.data = input.next();
			pnode.right = null;
			pnode.left = null;

			System.out.println("输入该节点的父节点数据");
			data = input.next();
			parent = TreeFindNode(treeNode, data);

			if (parent == null) {
				System.out.println("未找到该父节点");
				pnode = null;
				return;
			}

			System.out.println("1.添加该节点左子树 2.添加该节点的右子树");
			do {
				menusel = input.nextInt();
				if (menusel == 1 || menusel == 2) {
					if (parent == null) {
						System.out.println("不存在父节点,请先设置父节点");
					} else {
						switch (menusel) {
						case 1:
							if (parent.left != null) {
								System.out.println("左子树节点不为空");
							} else {
								parent.left = pnode;
							}
							break;

						case 2:
							if (parent.right != null) {
								System.out.println("右子树的节点不为空");
							} else {
								parent.right = pnode;
							}
							break;
						default:
							System.out.println("参数无效");
						}
					}
				}

			} while (menusel != 1 && menusel != 2);
		}
	}

	/**
	 * @Title: TreeFindNode
	 * @Description: (查找节点)
	 * @param treeNode
	 * @param data
	 * @return
	 * @return CBTType 返回类型
	 */
	CBTType TreeFindNode(CBTType treeNode, String data) {
		CBTType ptr;
		if (treeNode == null) {
			return null;
		} else {
			if (treeNode.data.equals(data)) {
				return treeNode;
			} else {
				if ((ptr = TreeFindNode(treeNode.left, data)) != null) {
					return ptr;
				} else if ((ptr = TreeFindNode(treeNode.right, data)) != null) {
					return ptr;
				} else {
					return null;
				}
			}
		}
	}

	/**
	 * 获取左子树
	 */
	CBTType TreeLeftNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.left;
		} else {
			return null;
		}
	}

	/**
	 * 获取右子树
	 */
	CBTType TreeRightNode(CBTType treeNode) {
		if (treeNode != null) {
			return treeNode.right;
		} else {
			return null;
		}
	}

	/**
	 * 判断空树
	 */
	int TreeIsEmpty(CBTType treeNode) {
		if (treeNode != null) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 计算二叉树的深度
	 */
	int TreeDepth(CBTType treeNode) {
		int depright, depleft;
		if (treeNode == null) {
			return 0;
		}

		depleft = TreeDepth(treeNode.left);
		depright = TreeDepth(treeNode.right);
		if (depleft > depright) {
			return depleft + 1;
		} else {
			return depright + 1;
		}
	}

	/**
	 * 清空二叉树
	 */
	void ClearTree(CBTType treeNode) {
		if (treeNode != null) {
			ClearTree(treeNode.left);
			ClearTree(treeNode.right);
			treeNode = null;
		}
	}

	/**
	 * 显示节点数据
	 */
	void TreeNodeData(CBTType p) {
		System.out.printf("%s", p.data);

	}

	/**
	 * 按层遍历
	 */
	void LevelTree(CBTType treeNode) {
		CBTType p;
		CBTType[] q = new CBTType[MAXLEN];
		int head = 0, tail = 0;

		if (treeNode != null) {
			tail = (tail + 1) % MAXLEN;
			q[tail] = treeNode;
		}

		while (head != tail) {
			head = (head + 1) % MAXLEN;
			p = q[head];
			TreeNodeData(p);
			if(p.left!=null){
				tail = (tail+1)%MAXLEN;
				q[tail] = p.left;
			}
			
			if(p.right!=null){
				tail = (tail+1)%MAXLEN;
				q[tail] = p.right;
			}
		}
	}

	/**
	 * 先序遍历
	 */
	void DLRTree(CBTType treeNode){
		if(treeNode!=null){
			TreeNodeData(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	/**
	 * 中序遍历
	 */
	void LDRTree(CBTType treeNode){
		if(treeNode!=null){
			LDRTree(treeNode.left);
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	/**
	 * 后序遍历
	 */
	void LRDTree(CBTType treeNode){
		if(treeNode!=null){
			LRDTree(treeNode.left);
			LDRTree(treeNode.right);
			TreeNodeData(treeNode);
		}
	}
}