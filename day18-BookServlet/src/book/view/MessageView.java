package book.view;

public class MessageView implements BookView {

	@Override
	public void display(Object object) {
		// TODO Auto-generated method stub
		String message = (String)object;
		System.out.println(message);
	}

}
