package top.yangguangyuan.chapter2.datastructure;

/**
 * @ClassName: Exercise2 
 * @Description: TODO(栈结构) 
 * @author yangguangyuan
 * @date 2017年7月7日 下午6:00:55 
 *
 */
public class Exercise3 {

}


/**
 * 数据
 */
class DATA3{
	String name;
	int age;
}

class StackType{
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN+1];
	int top;
}