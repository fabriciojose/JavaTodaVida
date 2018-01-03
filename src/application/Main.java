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
	
	// criar os controladores como variáveis globais
		TextField txtLogin;
		PasswordField txtSenha;
		
		Button btnEntrar = new Button ("Entrar");
		Button btnSair = new Button ("Sair");
		
		// método principal
		public static void main(String[] args) {
			

		}

		// método start
		public void start(Stage stage) throws Exception {
			
			// painel de ancoragem
			AnchorPane pane = new AnchorPane();
			pane.setPrefSize(400, 500);
			
			txtLogin.setText("Digite seu id");
			txtLogin.setText("Digite a senha");
					
			pane.getChildren().add(txtLogin);
			pane.getChildren().add(txtSenha);
			pane.getChildren().add(btnEntrar);
			pane.getChildren().add(btnSair);
			
			//criar uma cena
			Scene scene = new Scene(pane);
			// com a cena, o container principal da aplicação, dela se define o layout dos componentes
			
			stage.setScene(scene);
			
			// implementar o CSS
			pane.setStyle("fx-background-color: linear-gradient (from 0% to 100% 100% blue 0% silver 100%)");
			
			
			stage.show();
			
			// definir o layout dos componentes
			txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth())/2);
			txtLogin.setLayoutY(50);
			
			txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth())/2);
			txtSenha.setLayoutY(100);
			
			btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth())/2);
			btnEntrar.setLayoutY(100);
		
			btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth())/2);
			btnSair.setLayoutY(200);
			
			// chamar o método
			initListeners();
			
			
			
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
}