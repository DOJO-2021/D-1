package model;
import java.io.Serializable;

public class ResultBeans implements Serializable {
	private String message;		// メッセージ
	private String backTo;		// 戻り先

		//引数があるコンストラクタ
		public ResultBeans(String message, String backTo ) {
			this.message = message;
			this.backTo = backTo;
		}

		//引数がないコンストラクタ
		public ResultBeans() {
			this.message = "";
			this.backTo = "";
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getBackTo() {
			return backTo;
		}

		public void setBackTo(String backTo) {
			this.backTo = backTo;
		}
}