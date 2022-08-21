package fr.M2L_Add;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.M2L_Add.Cellule;
import fr.M2L_Add.Acces_BDD;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyController implements Initializable {

	@FXML
	private Pane authentification,accueil,ajouter,modifier,parametres,modifierCadre,ajouterCadre;
	
	@FXML
	private TextField authentificationIdentifiant,ajouterIdentifiantT,modifierIdentifiantT,mysqlServeurIP,mysqlServeurPort,baseNom;
	
	@FXML
	private PasswordField authentificationPassword,ajouterMdp1T,ajouterMdp2T,modifierMdp1T,modifierMdp2T,modifierMdp3T;
	
	@FXML
	private TableView<Cellule> accueilTable;
	
	@FXML
	private TableColumn<Cellule, String> accueilIdentifiantC,accueilDateC;
	
	@FXML
	private Button accueilAjouterB,accueilModifierB,accueilSupprimerB,accueilParametresB,ajouterAjouterB,ajouterRetourB,modifierModifierB,modifierRetourB,btnClose,btnMinimize,parametresRetourB,parametresServeurB,parametresDecoB;
	
	private Acces_BDD bdd;

//Initialisation
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			loadPrefFile();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		bdd=new Acces_BDD(mysqlServeurIP.getText(),mysqlServeurPort.getText(),baseNom.getText());
		authentification.setVisible(true);
		authentification.setStyle("-fx-opacity: 1;-fx-background-color: transparent;");
		accueilIdentifiantC.setCellValueFactory(new PropertyValueFactory<Cellule, String>("v1"));
		accueilDateC.setCellValueFactory(new PropertyValueFactory<Cellule, String>("v2"));
	}

//Fenêtre
	@FXML
    void close(ActionEvent event) {
    	Stage window=(Stage) btnClose.getScene().getWindow();
    	window.close();
    }
    
    @FXML
    void minimize(ActionEvent event) {
    	Stage window=(Stage) btnMinimize.getScene().getWindow();
    	window.setIconified(true);
    }
	
//Authentification
    @FXML
    void checkAuthentification(ActionEvent event) throws SQLException {
    	authentificationIdentifiant.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
		authentificationPassword.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
    	if(bdd.connexion(authentificationIdentifiant.getText(), authentificationPassword.getText(), 1)) {
    		majTable();
    		transitionPage(authentification,accueil,true);
    		authentificationIdentifiant.setText("");
    		authentificationPassword.setText("");
    	}else {
    		authentificationIdentifiant.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
    		authentificationPassword.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
    		fieldMove(authentificationIdentifiant);
			fieldMove(authentificationPassword);
    	}
    }
    
    void fieldMove(Node field) {
    	TranslateTransition t=new TranslateTransition(Duration.millis(100), field);
    	t.setToX(8);
    	t.setOnFinished(e -> {
    		t.setToX(-12);
    		t.setOnFinished(e1 -> {
    			t.setToX(8);
    			t.setOnFinished(e2 -> {
    				t.setToX(-6);
    				t.setOnFinished(e3 -> {
    					t.setToX(4);
    					t.setOnFinished(e4 -> {
    						t.setToX(-2);
    						t.play();
    						t.stop();
    					});
    					t.play();
    				});
    				t.play();
    			});
    			t.play();
    		});
    		t.play();
    	});
    	t.play();
    }

//Accueil
    void majTable() throws SQLException {
		ArrayList<Cellule> data=bdd.getEmploye();
		accueilTable.setItems(getObservableList(data));
	}

//Paramètres
	@FXML
    void deconnexion(ActionEvent event) {
    	authentificationIdentifiant.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
		authentificationPassword.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
		authentificationIdentifiant.setText("");
		authentificationPassword.setText("");
    	transitionPage(parametres,authentification,false);
    }

    @FXML
	void changeServeurMySQLIP(ActionEvent event) {
		if(!mysqlServeurIP.getText().equals("")) {
			prefFileMAJ();
		}
	}
	
	@FXML
	void changeServeurMySQLPort(ActionEvent event) {
		if(!mysqlServeurPort.getText().equals("")) {
			prefFileMAJ();
		}
	}
	
	@FXML
	void changeDatabaseName(ActionEvent event) {
		if(!baseNom.getText().equals("")) {
			prefFileMAJ();
		}
	}
	
	@FXML
	void displayParametres(ActionEvent event) {
		transitionPage(accueil,parametres,true);
	}

//Modifier
	@FXML
	void displayModifier(ActionEvent event) {
		Object o=accueilTable.getSelectionModel().getSelectedItem();
		if(o!=null) {
			String identifiant=((Cellule)o).getV1();
			modifierIdentifiantT.setText(identifiant);
			transitionPage(accueil,modifier,false);
		}
	}

	@FXML
	void modifierB(ActionEvent event) throws SQLException {
		Object o=accueilTable.getSelectionModel().getSelectedItem();
		int id=((Cellule)o).getId();
		modifierIdentifiantT.setStyle("-fx-border-width: 1;-fx-background-color: white;-fx-text-fill: black;-fx-border-color: grey;");
		modifierMdp1T.setStyle("-fx-border-width: 1;-fx-background-color: white;-fx-text-fill: black;-fx-border-color: grey;");
		modifierMdp3T.setStyle("-fx-border-width: 1;-fx-background-color: white;-fx-text-fill: black;-fx-border-color: grey;");
		String identifiant=modifierIdentifiantT.getText();
		if(!identifiant.equals("")&&!bdd.exist(identifiant,id)) {
			if(bdd.checkMdp(modifierMdp1T.getText(), id)) {
				if(modifierMdp2T.getText().equals(modifierMdp3T.getText())) {
					bdd.modifier(identifiant, modifierMdp2T.getText(), id);
				}else {
					modifierMdp3T.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
					fieldMove(modifierMdp3T);
				}
			}else {
				modifierMdp1T.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
				fieldMove(modifierMdp1T);
			}
		}else {
			modifierIdentifiantT.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
			fieldMove(modifierIdentifiantT);
		}
	}

//Ajouter
	@FXML
	void displayAjouter(ActionEvent event) {
		transitionPage(accueil,ajouter,false);
	}

	@FXML
	void ajouterB(ActionEvent event) throws SQLException {
		ajouterIdentifiantT.setStyle("-fx-border-width: 1;-fx-background-color: white;-fx-text-fill: black;-fx-border-color: grey;");
		ajouterMdp2T.setStyle("-fx-border-width: 1;-fx-background-color: white;-fx-text-fill: black;-fx-border-color: grey;");
		String identifiant=ajouterIdentifiantT.getText();
		if(!identifiant.equals("")&&!bdd.exist(identifiant,0)) {
			if(ajouterMdp1T.getText().equals(ajouterMdp2T.getText())) {
				bdd.add(identifiant, ajouterMdp1T.getText());
				ajouterIdentifiantT.setText("");
				ajouterMdp1T.setText("");
				ajouterMdp2T.setText("");
			}else {
				ajouterMdp2T.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
				fieldMove(ajouterMdp2T);
			}
		}else {
			ajouterIdentifiantT.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
			fieldMove(ajouterIdentifiantT);
		}
	}

//Supprimer
	@FXML
	void supprimer(ActionEvent event) throws SQLException {
		Object o=accueilTable.getSelectionModel().getSelectedItem();
		if(o!=null) {
			int id=((Cellule)o).getId();
			bdd.delete(id);
		}
		majTable();
	}

//Général
	ObservableList getObservableList(ArrayList data) {
		ObservableList out=FXCollections.observableArrayList();
		for(Object l: data) {
			out.add(l);
		}
		return(out);
	}
	
	@FXML
    void elementPressed(MouseEvent event) {
    	ScaleTransition s=new ScaleTransition(Duration.millis(250), (Node)event.getSource());
		s.setToX(.97);
		s.setToY(.97);
		s.play();
    }
    
    @FXML
    void elementReleased(MouseEvent event) {
    	ScaleTransition s=new ScaleTransition(Duration.millis(250), (Node)event.getSource());
		s.setToX(1);
		s.setToY(1);
		s.play();
    }
    
    @FXML
    void retour(ActionEvent event) throws SQLException {
    	majTable();
    	Pane parent=(Pane)((Button)event.getSource()).getParent();
    	transitionPage(parent,accueil,true);
    }
    
    @FXML
    void nextField(ActionEvent event) {
    	TextField field=(TextField)event.getSource();
    	String style,style2="-fx-background-radius: 3;-fx-border-radius: 3;-fx-border-width: 0.5;-fx-border-color: black;";
    	style="-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;";
		if(!field.getParent().getStyleClass().get(0).toString().equals("page")) {style+=style2;}
		field.setStyle(style);
    	Boolean ok=false;
    	for(Node node: field.getParent().getChildrenUnmodifiable()) {
    		if(node instanceof TextField||node instanceof PasswordField) {
    			if(ok) {
    				node.requestFocus();
    				break;
    			}
    			else if(node==field) {
    				ok=true;
    			}
    		}
    	}
    }
	
	void transitionPage(Node p1, Node p2, Boolean annimMenu) {
		ArrayList<FadeTransition> out=new ArrayList<FadeTransition>();
		p2.setVisible(true);
		FadeTransition tp1=new FadeTransition(Duration.millis(500), p1);
		tp1.setFromValue(1);
		tp1.setToValue(0);
		tp1.setOnFinished(e -> {
			p1.setVisible(false);
		});
		FadeTransition tp2=new FadeTransition(Duration.millis(500), p2);
		tp2.setFromValue(0);
		tp2.setToValue(1);
		if((p2.equals((Node)accueil)||p2.equals((Node)parametres)&&annimMenu)) {
			ArrayList<Node>btns=new ArrayList<Node>();
			if(p2.equals((Node)accueil)){
				for(Node n:accueil.getChildren()) {if(n instanceof Button) {btns.add(n);}}
			}else if(p2.equals((Node)parametres)){
				for(Node n:parametres.getChildren()) {if(n instanceof Button) {btns.add(n);}}
			}
			btns.remove(0);
			for(Node btn:btns) {btn.setTranslateY(0);}
			tp2.setOnFinished(e -> {
				int i=1;
				for(Node btn: btns) {
					TranslateTransition tb=new TranslateTransition(Duration.millis(i*250), btn);
					tb.setToY(i*93.75);
					tb.play();
					i++;
				}
			});
		}
		tp1.play();
		tp2.play();
	}
	
	void prefFileMAJ() {
		
		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			Writer wr = new FileWriter(currentDirectory.getCanonicalPath()+"\\src\\fr\\M2L_Add\\Ressources\\SCPrefs");
			String data="";
			data+="IP:"+mysqlServeurIP.getText()+"\n";
			data+="Port:"+mysqlServeurPort.getText()+"\n";
			data+="Nom:"+baseNom.getText()+"\n";
			wr.write(data);
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	void loadPrefFile() throws IOException, URISyntaxException {
		File currentDirectory,file;
		currentDirectory = new File(new File(".").toString());
		file = new File(currentDirectory.getCanonicalPath()+"\\src\\fr\\M2L_Add\\Ressources\\SCPrefs");
		Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String [] line = scanner.nextLine().split(":");
            if(line[0].equals("IP")) {
            	mysqlServeurIP.setText(line[1]);
            }else if(line[0].equals("Port")) {
            	mysqlServeurPort.setText(line[1]);
            }else if(line[0].equals("Nom")) {
            	baseNom.setText(line[1]);
            }
        }
	}
	
}
