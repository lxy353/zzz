/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author lxz35
 *
 */
public class TalkT {
	public static void main(String[] args) {
		new Thread(new Talkreceive(9999)).start();
	}

}
