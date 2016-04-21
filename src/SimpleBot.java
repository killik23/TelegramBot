import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class SimpleBot extends TelegramLongPollingBot {

	public static void main(String[] args) {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new SimpleBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return "Hehoha_bot";
	}

	@Override
	public String getBotToken() {
		return "210742667:AAEU0c7aCuYdP1qs0HcAaVRzwLMNPtPbhrE";
	}

	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		if (message != null && message.hasText()) {
			if (message.getText().equals("/help"))
				sendMsg(message, "ѕривет, € робот");
			if (message.getText().equals("»ди нахуй"))
				sendMsg(message, "—ам иди нахуй!");
			if (message.getText().equals("шутки за 300"))
				sendMsg(message, "Ч —кажи триста. Ч “риста. Ч јбстрагируйс€ от суеты, достигнув с космосом единства.");	
			}
			else
				sendMsg(message, "я не знаю что ответить на это");
	}

	private void sendMsg(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplayToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}