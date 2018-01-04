package application;
	
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	// criar os componentes como variáveis globais
	
		
		private AnchorPane pane;
		private TextField txtLogin;
		private PasswordField txtSenha;
		private Button btnEntrar, btnSair;
		private static Stage stage;
		
		
		
		@Override // método start
		public void start(Stage stage) throws Exception {
			
			initComponents();
			initListeners();
			
			//criar uma cena
			Scene scene = new Scene(pane);
			
			// com a cena, o container principal da aplicação, dela se define o layout dos componentes
			stage.setScene(scene);
			
			stage.setResizable(false);
			
			stage.setTitle("Login - Adasa");
			
			stage.show();
				
			initLayout();
			
			//indicar a variável stage
			Main.stage = stage;
			
			// chamar o método
			
		}
		
		// criar o geter da variável stage
		public static Stage getStage () {
			return stage;
		}
		
		private void initComponents() {
			
			pane = new AnchorPane();
			pane.setPrefSize(300, 350);
			
			txtLogin = new TextField();
			txtLogin.setPromptText("Digite seu id");
			
			txtSenha = new PasswordField();
			txtSenha.setPromptText("Digite a senha:");
			
			btnEntrar  = new Button("Entrar");
			
			btnSair = new Button ("Sair");
			
			pane.getChildren().addAll(txtLogin, txtSenha, btnEntrar, btnSair);
			
			
			
			
		}
		private void initLayout () {
			
			// definir o layout dos componentes
			txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth())/2);
			txtLogin.setLayoutY(50);
						
			txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth())/2);
			txtSenha.setLayoutY(100);
						
			btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth())/2);
			btnEntrar.setLayoutY(150);
					
			btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth())/2);
			btnSair.setLayoutY(200);
						
			// implementar o CSS
			pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
		}
				
		private void initListeners () {
			// criar ação para o botão sair
			btnSair.setOnAction(new EventHandler <ActionEvent>() {
				
				public void handle (ActionEvent event) {
					fecharAplicacao();
				}
			});
			
			// criar ação  para o botão entrar
			btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
				public void handle (ActionEvent event) {
					logar();
				}
			});
				
			
		}
		
		private void logar () {
			if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("123")) {
				JOptionPane.showMessageDialog(null, "Você entrou com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		}
		private void fecharAplicacao () {
			System.exit(0);
		}
		
		// método principal
		public static void main(String[] args) {
			launch (args);
		}
}