/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * @author lxz35
 *
 */
public class TalkS {
	public static void main(String[] args) {
		new Thread(new TalkSend(9999)).start();//����
	}

}
