/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * @author lxz35
 *
 */
public class TalkT {
	public static void main(String[] args) {
		new Thread(new Talkreceive(9999)).start();
	}

}
