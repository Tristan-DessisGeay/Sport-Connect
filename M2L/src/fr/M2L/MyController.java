package fr.M2L;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.print.DocFlavor.URL;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyController implements Initializable {
	
	@FXML
	private Pane paneAuthentification;
	
	@FXML
    private TextField idField;
	
	@FXML
    private Pane mainUI;
	
	@FXML
    private Pane root;
	
	@FXML
    private Button btnCompetition;
	
	@FXML
    private Button btnParametre;

    @FXML
    private Button btnEquipe;
    
    @FXML
    private Button btnPersonne;

    @FXML
    private Button btnClose;
    
    @FXML
    private Button btnDeconnection;
    
    @FXML
    private Button btnGeneral;
    
    @FXML
    private Button btnApparence;
    
    @FXML
    private Button btnRaccourcie;
    
    @FXML
    private Button btnSecurite;
    
    @FXML
    private Pane generalAffichage;
    
    @FXML
    private Button btnAide;
    
    @FXML
    private Button btnMySQL;
    
    @FXML
    private Button btnInfoBDD;
    
    @FXML
    private PasswordField idMdp;
    
    @FXML
    private Pane background;
    
    @FXML
    private Pane parametre;
    
    @FXML
    private ImageView logo;
    
    @FXML
    private Button btnMinimize;
    
    @FXML
    private Button changeMode;
    
    @FXML
    private Pane affichageParams;
    
    @FXML
    private Pane mySQLAffichage;
    
    @FXML
    private Pane aideAffichage;
    
    @FXML
    private Pane paramsDisplayCadre;
    
    @FXML
    private Pane generalAffichage1;
    
    @FXML
    private Pane generalAffichage2;
    
    @FXML
    private Pane generalAffichage3;
    
    @FXML
    private Label labelModeSombre;
    
    @FXML
    private Label labelRaccourcieDeco;
    
    @FXML
    private Label labelRaccourciePagePrec;
    
    @FXML
    private Label labelRaccourciePageSuiv;
    
    @FXML
    private TextField raccourcieFieldDeco;
    
    @FXML
    private TextField raccourcieFieldPageSuiv;
    
    @FXML
    private ListView listCtrlDeco;
    
    @FXML
    private ListView listCtrlPagePrec;
    
    @FXML
    private ListView listCtrlPageSuiv;
    
    @FXML
    private TextField raccourcieFieldPagePrec;
    
    @FXML
    private TextField idFieldParam,mdpAncienFieldParam,mdpNouveauFieldParam,mdpNouveauConfirmFieldParam;
    
    @FXML
    private Button btnAideUtilisation,btnAideCredits;
    
    @FXML
    private Pane aideAffichage1,aideAffichage2;
    
    @FXML
    private Pane personne, personneCadreGauche;
    
    @FXML
    private Pane personneResultatCadre, personneFiltreContenu;
    
    @FXML
    private ScrollPane personneFiltresCadre, personneResultatContenu;
    
    @FXML
    private TextField personneFiltrePrenom, personneFiltreNom, personneFiltreDate, personneFiltreEmail;
    
    @FXML
    private Button personneFiltrePrenomB, personneFiltreNomB, personneFiltreDateB, personneFiltreEmailB, personneFiltreSexeB, personneFiltreVilleB, personneFiltreEquipeB;
    
    @FXML
    private ListView personneFiltreSexe, personneFiltreVille, personneFiltreEquipe;
    
    @FXML
    private Button personneRechercheB, personneAjouterB;
    
    @FXML
    private Pane personneAjoutCadreB, personneContentGauche, personneAjouterChampsContenu, personneContentDroite;
    
    @FXML
    private TableView<Cellule> personneDisplayResultT;
    
    @FXML
    private TableColumn<Cellule, String> personnePrenomC, personneNomC;
    
    @FXML
    private Pane modificationCompetiteur;
    
    @FXML
    private Button modificationCompetiteurM, modificationCompetiteurS;
    
    @FXML
    private TextField modificationCompetiteurPrenom, modificationCompetiteurNom, modificationCompetiteurEmail, modificationCompetiteurDate, modificationCompetiteurSexe, modificationCompetiteurVille;
    
    @FXML
    private ListView modificationCompetiteurSexeL, modificationCompetiteurVilleL;
    
    @FXML
    private Button modificationCompetiteurEquipe;
    
    @FXML
    private Pane modificationCompetiteurContenu;
    
    @FXML
    private Button personneAjouterNouvelle, personneAjouterModifier, personneAjouterSupprimer, personneAjouterEquipe;
    
    @FXML
    private TextField personneAjouterPrenom, personneAjouterNom, personneAjouterDate, personneAjouterEmail, personneAjouterSexeT, personneAjouterVilleT;
    
    @FXML
    private ListView personneAjouterSexe, personneAjouterVille;
    
    @FXML
    private Pane cadreActionValidation;
    
    @FXML
    private ImageView actionValidation;
    
    @FXML
    private Button equipeRechercheB, equipeAjouterB, equipeAjouterNouvelle, equipeAjouterModifier, equipeAjouterSupprimer;
    
    @FXML
    private Pane equipe, equipeCadreGauche, equipeContentGauche, equipeFiltreContenu, equipeAjoutCadreB, equipeResultatCadre, equipeContentDroite, equipeAjouterChampsContenu;
    
    @FXML
    private ScrollPane equipeFiltresCadre, equipeResultatContenu;
    
    @FXML
    private TableView<Cellule> equipeDisplayResultT;
    
    @FXML
    private TableColumn<Cellule, String> equipeNomC, equipeVilleC;
    
    @FXML
    private TextField equipeAjouterNom, equipeAjouterTypeT, equipeAjouterVilleT, equipeAjouterSportT;
    
    @FXML
    private ListView equipeAjouterType, equipeAjouterVille, equipeAjouterSport;
    
    @FXML
    private TextField equipeFiltreNom;
    
    @FXML
    private ListView equipeFiltreType, equipeFiltreVille, equipeFiltreSport;
    
    @FXML
    private Button equipeFiltreTypeB, equipeFiltreNomB, equipeFiltreVilleB, equipeFiltreSportB;
    
    @FXML
    private ListView personneFiltreSport;
    
    @FXML
    private Button personneFiltreSportB;
    
    @FXML
    private TextField modificationCompetiteurSport;
    
    @FXML
    private ListView modificationCompetiteurSportL;
    
    @FXML
    private ScrollPane modificationCompetiteurCadre;
    
    @FXML
    private TextField personneAjouterSportT;
    
    @FXML
    private ListView personneAjouterSport;
    
    @FXML
    private Button modificationEquipeC, modificationEquipeM, modificationEquipeS;
    
    @FXML
    private ScrollPane modificationEquipeCadreTop;
    
    @FXML
    private Pane modificationEquipeContenu, modificationEquipe;
    
    @FXML
    private TextField modificationEquipeNom, modificationEquipeType, modificationEquipeSport, modificationEquipeVille;
    
    @FXML
    private ListView modificationEquipeTypeL, modificationEquipeVilleL, modificationEquipeSportL;
    
    @FXML
    private Pane modificationEquipeCadre, modificationEquipeCadreBottom, modificationEquipeContent, modificationEquipeCadreBtn, modificationEquipeContentBtn;
    
    @FXML
    private Button modificationEquipeAS, modificationEquipeD;
    
    @FXML
    private TextField equipeModificationFiltrePrenom, equipeModificationFiltreNom, equipeModificationFiltreDateNaissance, equipeModificationFiltreEmail;
    
    @FXML
    private ListView equipeModificationFiltreVille, equipeModificationFiltreSexe;
    
    @FXML
    private Button equipeModificationFiltrePrenomB, equipeModificationFiltreNomB, equipeModificationFiltreDateNaissanceB, equipeModificationFiltreEmailB, equipeModificationFiltreVilleB, equipeModificationFiltreSexeB;
    
    @FXML
    private ScrollPane equipeModificationFiltresCadre;
    
    @FXML
    private Pane equipeModificationFiltreContenu;
    
    @FXML
    private Label equipeModificationLabelSexe;
    
    @FXML
    private ScrollPane equipeModificationResultatContenuTop, equipeModificationResultatContenuBottom;
    
    @FXML
    private TableView<Cellule> equipeModificationDisplayResultTTop;
    
    @FXML
    private TableColumn<Cellule, String> equipeModificationPrenomCTop, equipeModificationNomCTop;
    
    @FXML
    private TableView<Cellule> equipeModificationDisplayResultTBottom;
    
    @FXML
    private TableColumn<Cellule, String> equipeModificationPrenomCBottom, equipeModificationNomCBottom;
    
    @FXML
    private Button equipeModificationRechercherB;
    
    @FXML
    private Pane competition, competitionCadreGauche, competitionResultatCadre, competitionContentGauche, competitionAjoutCadreB, competitionFiltreContenu, competitionContentDroite, competitionAjouterChampsContenu;
    
    @FXML
    private Button competitionRechercheB, competitionAjouterB, competitionFiltreLibelleB, competitionFiltreDateDebutB, competitionFiltreDateFinB, competitionFiltreTypeB, competitionFiltreVilleB, competitionFiltreSportB;
    
    @FXML
    private ScrollPane competitionFiltresCadre, competitionResultatContenu;
    
    @FXML
    private TextField competitionFiltreLibelle, competitionFiltreDateFin, competitionFiltreDateDebut;
    
    @FXML
    private ListView competitionFiltreType, competitionFiltreVille, competitionFiltreSport;
    
    @FXML
    private Button competitionAjouterNouvelle, competitionAjouterSupprimer, competitionAjouterModifier;
    
    @FXML
    private TableView<Cellule> competitionDisplayResultT;
    
    @FXML
    private TableColumn<Cellule, String> competitionLibelleC, competitionTypeC;
    
    @FXML
    private TextField competitionAjouterLibelle, competitionAjouterTypeT, competitionAjouterVilleT, competitionAjouterSportT, competitionAjouterDateDebutT, competitionAjouterDateFinT;
    
    @FXML
    private ListView competitionAjouterType, competitionAjouterVille, competitionAjouterSport;
    
    @FXML
    private Pane modificationCompetition, modificationCompetitionCadre, modificationCompetitionContent, modificationCompetitionContenu, modificationCompetitionCadreBottom, competitionModificationFiltreContenu;
    
    @FXML
    private ScrollPane modificationCompetitionCadreTop, competitionModificationFiltresCadre;
    
    @FXML
    private TextField modificationCompetitionLibelle, modificationCompetitionType, modificationCompetitionVille, modificationCompetitionSport, modificationCompetitionDateDebut, modificationCompetitionDateFin;
    
    @FXML
    private ListView modificationCompetitionTypeL, modificationCompetitionVilleL, modificationCompetitionSportL;
    
    @FXML
    private TextField competitionModificationFiltrePrenom, competitionModificationFiltreNom, competitionModificationFiltreDateNaissance, competitionModificationFiltreEmail;
    
    @FXML
    private Button competitionModificationFiltreNomB , competitionModificationFiltreVilleB, competitionModificationFiltreTypeB;
    
    @FXML
    private ListView competitionModificationFiltreVille, competitionModificationFiltreType;
    
    @FXML
    private Label competitionModificationLabelType;
    
    @FXML
    private ScrollPane competitionModificationResultatContenuTop, competitionModificationResultatContenuBottom;
    
    @FXML
    private TableView<Cellule> competitionModificationDisplayResultTTop;
    
    @FXML
    private TableColumn<Cellule, String> competitionModificationNomCTop, competitionModificationVilleCTop;
    
    @FXML
    private TableView<Cellule> competitionModificationDisplayResultTBottom;
    
    @FXML
    private TableColumn<Cellule, String> competitionModificationNomCBottom, competitionModificationVilleCBottom;
    
    @FXML
    private Button competitionModificationRechercherB;
    
    @FXML
    private Pane modificationCompetitionCadreBtn, modificationCompetitionContentBtn;
    
    @FXML
    private Button modificationCompetitionM, modificationCompetitionS, modificationCompetitionE, modificationCompetitionAS, modificationCompetitionD;
    
    @FXML
    private PieChart diagrammeTypeEquipe, diagrammeSportCompetiteur;
    
    @FXML
    private Label prochaineCompetition;
    
    @FXML
    private Pane cadreProchaineCompetition;
    
    @FXML
    private TextField mysqlServeurIP, mysqlServeurPort, baseNom;
    
    @FXML
    private Button modificationEquipeHistorique,equipeModificationHistoriqueRechercher;
    
    @FXML
    private Pane equipeModificationHistoriquePage,equipeModificationHistoriqueFilters;
    
    @FXML
    private ScrollPane equipeModificationHistoriqueResultats;
    
    @FXML
    private TableView<Cellule> equipeModificationHistoriqueResultatsTable;
    
    @FXML
    private TableColumn<Cellule, String> equipeModificationHistoriqueResultatsNom, equipeModificationHistoriqueResultatsVille;
    
    @FXML
    private TextField equipeModificationHistoriqueDateDebut, equipeModificationHistoriqueDateFin;
    
    private Button actuelParam,actuelSubParam1,actuelSubParam2,actuelSubParam3, actuelPersonne, actuelEquipe, actuelCompetition;
    
    private Boolean sombre=false;
    
    private ArrayList<String[]> shortcuts=new ArrayList<String[]>();
    
    private ArrayList<Node> history=new ArrayList<Node>();
    private int nbrSubPages=4;
    private int indexHistory=0;
    private Node field;
    private ArrayList<TextField> modifyTextField=new ArrayList<TextField>();
    private int indexElementAdded=0;
    private Boolean toogleAddPersonne=false, actionConfirmedRefusedAnnimFinished=true, toogleAddEquipe=false, toogleModificationEquipe=true, toogleAddCompetition=false, toogleModificationCompetition=true;
    private Boolean annimEnded=true;
    
    private Acces_BDD bdd;

//Méthode d'initialisation
    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        paramsDisplayCadre.setClip(new Rectangle(375, 451));
        personneCadreGauche.setClip(new Rectangle(337.5, 395));
        personneResultatCadre.setClip(new Rectangle(337.5, 450));
        equipeCadreGauche.setClip(new Rectangle(337.5, 395));
        equipeResultatCadre.setClip(new Rectangle(337.5, 450));
        cadreActionValidation.setClip(new Rectangle(60, 60));
        modificationEquipeCadre.setClip(new Rectangle(700,375));
        modificationCompetitionCadre.setClip(new Rectangle(700,375));
        modificationEquipeCadreBtn.setClip(new Rectangle(700,50));
        modificationCompetitionCadreBtn.setClip(new Rectangle(700,50));
        competitionResultatCadre.setClip(new Rectangle(337.5, 450));
        competitionCadreGauche.setClip(new Rectangle(337.5, 395));
        cadreProchaineCompetition.setClip(new Rectangle(385.0,75.0));
        /*
        personneFiltresCadre.setContent(personneFiltreContenu);
        personneResultatContenu.setContent(personneDisplayResultT);
        modificationCompetiteurCadre.setContent(modificationCompetiteurContenu);
        equipeFiltresCadre.setContent(equipeFiltreContenu);
        equipeModificationFiltresCadre.setContent(equipeModificationFiltreContenu);
        equipeModificationResultatContenuTop.setContent(equipeModificationDisplayResultTTop);
        equipeModificationResultatContenuBottom.setContent(equipeModificationDisplayResultTBottom);
        competitionFiltresCadre.setContent(competitionFiltreContenu);
        competitionResultatContenu.setContent(competitionDisplayResultT);
        competitionModificationFiltresCadre.setContent(competitionModificationFiltreContenu);
        competitionModificationResultatContenuTop.setContent(competitionModificationDisplayResultTTop);
        competitionModificationResultatContenuBottom.setContent(competitionModificationDisplayResultTBottom);
        equipeModificationHistoriqueResultats.setContent(equipeModificationHistoriqueResultatsTable);
        */
        ArrayList<ScrollPane> scrollPaneList=new ArrayList<ScrollPane>();
        scrollPaneList.add(personneFiltresCadre);
        scrollPaneList.add(personneResultatContenu);
        scrollPaneList.add(modificationCompetiteurCadre);
        scrollPaneList.add(equipeFiltresCadre);
        scrollPaneList.add(equipeModificationFiltresCadre);
        scrollPaneList.add(equipeModificationResultatContenuTop);
        scrollPaneList.add(equipeModificationResultatContenuBottom);
        scrollPaneList.add(competitionFiltresCadre);
        scrollPaneList.add(competitionResultatContenu);
        scrollPaneList.add(competitionModificationFiltresCadre);
        scrollPaneList.add(competitionModificationResultatContenuTop);
        scrollPaneList.add(competitionModificationResultatContenuBottom);
        scrollPaneList.add(equipeModificationHistoriqueResultats);
        for(ScrollPane sp:scrollPaneList){
            sp.setHbarPolicy(ScrollBarPolicy.NEVER);
            sp.setVbarPolicy(ScrollBarPolicy.NEVER);
        }
        actuelParam=btnGeneral;
        actuelSubParam1=btnApparence;
        actuelSubParam2=btnInfoBDD;
        actuelSubParam3=btnAideUtilisation;
        actuelPersonne=personneRechercheB;
        actuelEquipe=equipeRechercheB;
        actuelCompetition=competitionRechercheB;
        loadPrefFile();
        ArrayList<Pane>paneList=new ArrayList<Pane>();
        paneList.add(mainUI);
        paneList.add(parametre);
        paneList.add(affichageParams);
        paneList.add(generalAffichage1);
        paneList.add(aideAffichage1);
        paneList.add(modificationCompetiteur);
        paneList.add(modificationCompetiteurContenu);
        paneList.add(personneAjoutCadreB);
        paneList.add(personneAjouterChampsContenu);
        paneList.add(personne);
        paneList.add(equipe);
        paneList.add(equipeAjoutCadreB);
        paneList.add(modificationEquipeContentBtn);
        paneList.add(modificationEquipeCadreBottom);
        paneList.add(competition);
        paneList.add(competitionAjoutCadreB);
        paneList.add(modificationCompetitionContentBtn);
        paneList.add(modificationCompetitionCadreBottom);
        paneList.add(equipeModificationHistoriquePage);
        paneList.add(modificationEquipeContenu);
        for(Pane p:paneList) {
            for(Node n:p.getChildren()) {
                if(n instanceof Button) {
                    n.setOnMouseEntered(e -> {
                        n.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
                    });
                    n.setOnMouseExited(e -> {
                        if(!n.equals((Node)actuelParam)&&!n.equals((Node)actuelSubParam1)&&!n.equals((Node)actuelSubParam2)&&!n.equals((Node)actuelSubParam3)&&!n.equals((Node)actuelPersonne)&&!n.equals((Node)actuelEquipe)&&!n.equals((Node)actuelCompetition)){
                            if(!sombre) {
                                if(n.getParent().getStyleClass().contains("sectionParams")) {
                                    n.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-border-width: 0.5;-fx-border-color: black;-fx-background-radius: 3;-fx-border-radius: 3;");
                                }else{
                                    n.setStyle("-fx-background-color: white;-fx-text-fill: black;");
                                }
                            }else {
                                if(n.getParent().getStyleClass().contains("sectionParams")) {
                                    n.setStyle("-fx-background-color: rgb(125,125,125);-fx-text-fill: white;-fx-border-width: 0.5;-fx-border-color: black;-fx-background-radius: 3;-fx-border-radius: 3;");
                                }else {
                                    n.setStyle("-fx-background-color: rgb(125,125,125);-fx-text-fill: white;");
                                }
                            }
                        }
                    });
                }
            }
        }
        
        //Initialisation des tableView
        ArrayList<TableColumn<Cellule,String>> tableColumnList=new ArrayList<TableColumn<Cellule,String>>();
        tableColumnList.add(personnePrenomC);
        tableColumnList.add(personneNomC);
        tableColumnList.add(equipeNomC);
        tableColumnList.add(equipeVilleC);
        tableColumnList.add(equipeModificationPrenomCTop);
        tableColumnList.add(equipeModificationNomCTop);
        tableColumnList.add(equipeModificationPrenomCBottom);
        tableColumnList.add(equipeModificationNomCBottom);
        tableColumnList.add(competitionLibelleC);
        tableColumnList.add(competitionTypeC);
        tableColumnList.add(competitionModificationNomCTop);
        tableColumnList.add(competitionModificationVilleCTop);
        tableColumnList.add(competitionModificationNomCBottom);
        tableColumnList.add(competitionModificationVilleCBottom);
        tableColumnList.add(equipeModificationHistoriqueResultatsNom);
        tableColumnList.add(equipeModificationHistoriqueResultatsVille);

        int nbr=1;
        for(TableColumn<Cellule,String> tc: tableColumnList){
            tc.setCellValueFactory(new PropertyValueFactory<Cellule, String>("v"+nbr));
            if(nbr==1){
                nbr=2;
            }else{
                nbr=1;
            }
        }
        
        //BDD
        bdd=new Acces_BDD(mysqlServeurIP.getText(),mysqlServeurPort.getText(),baseNom.getText());
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

    @FXML
    void rootShortcuts(KeyEvent event) throws SQLException {
        KeyCode k2=event.getCode();
        for(String[] s:shortcuts) {
            if(s[0].equals("   Ctrl")&&event.isControlDown()&&k2.equals(KeyCode.getKeyCode(s[1]))||s[0].equals("   Alt")&&event.isAltDown()&&k2.equals(KeyCode.getKeyCode(s[1]))||s[0].equals("   Maj")&&event.isShiftDown()&&k2.equals(KeyCode.getKeyCode(s[1]))) {
                if(s[2].equals("deconnection")) {lock();}
                else if(s[2].equals("page_precedente")) {historyMove(true);}
                else if(s[2].equals("page_suivante")) {historyMove(false);}
            }
        }
    }

//Veille
    @FXML
    void logoReleased(MouseEvent event) {
        elementReleased(event);
        transitionPage(logo,paneAuthentification,true);
        idField.requestFocus();
    }

//Authentification
    @FXML
    void checkAuthentification(ActionEvent event) throws SQLException {
        if(!sombre) {
            idField.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
            idMdp.setStyle("-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;");
        }else {
            idField.setStyle("-fx-border-width: 0;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;");
            idMdp.setStyle("-fx-border-width: 0;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;");
        }
        if(bdd.connexion(idField.getText(), idMdp.getText())) {
            //Mise à jour des catégories
            try {
                setCategoriesBDD();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            //Lancement du logiciel
            transitionPage(paneAuthentification,mainUI,true);
            idFieldParam.setText(idField.getText());
            idField.setText("");
            idMdp.setText("");
            diagrammeMAJ();
            prochaineCompetitionMAJ();
        }else {
            if(!sombre) {
                idMdp.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
                idField.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: white;-fx-text-fill: black;");
            }else {
                idMdp.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;");
                idField.setStyle("-fx-border-width: 1;-fx-border-color: red;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;");
            }
            fieldMove(idField);
            fieldMove(idMdp);
        }
    }

//Accueil
    void prochaineCompetitionMAJ() throws SQLException {
        ArrayList competitionPro=bdd.prochaineCompetition();
        Cellule c=new Cellule((String)competitionPro.get(0),(String)competitionPro.get(1),(int)competitionPro.get(2));
        ObservableList data=FXCollections.observableArrayList();
        data.add(c);
        competitionDisplayResultT.setItems(data);
        competitionDisplayResultT.getSelectionModel().select(0);
        prochaineCompetition.setText((String)competitionPro.get(0));
        int labelWidth=15*prochaineCompetition.getText().length()+385;
        Double annimTime=(double) (labelWidth*20000/2000);
        TranslateTransition tLabelCompetition=new TranslateTransition(Duration.millis(annimTime),prochaineCompetition);
        tLabelCompetition.setFromX(0);
        tLabelCompetition.setToX(-labelWidth);
        tLabelCompetition.setCycleCount(Animation.INDEFINITE);
        tLabelCompetition.play();
    }
    
    @FXML
    void goToProCompetition(MouseEvent event) throws SQLException {
        history.clear();
        history.add(mainUI);
        history.add(modificationCompetition);
        indexHistory=1;
        Object o=competitionDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        showCompetition(id);
        transitionPage(mainUI,modificationCompetition,false);
    }
    
    @FXML
    void diagrammeTypeEquipeClicked(MouseEvent event) throws SQLException {
        ObservableList<PieChart.Data> data=bdd.getDiagrammeData("equipeType");
        diagrammeTypeEquipe.setData(data);
        diagrammeTypeEquipe.setStartAngle(new Random().nextInt(360));
    }
    
    @FXML
    void diagrammeSportPratiqueClicked(MouseEvent event) throws SQLException {
        ObservableList<PieChart.Data> data=bdd.getDiagrammeData("sportPratique");
        diagrammeSportCompetiteur.setData(data);
        diagrammeSportCompetiteur.setStartAngle(new Random().nextInt(360));
    }

    void diagrammeMAJ() throws SQLException {
        diagrammeTypeEquipeClicked(null);
        diagrammeSportPratiqueClicked(null);
    }

//Paramètres
    @FXML
    void displayParametre(ActionEvent event) {
        transitionPage(mainUI,parametre,true);
        history.clear();
        indexHistory=1;
        history.add(mainUI);
        history.add(parametre);
        refreshShortcuts();
    }

    @FXML
    void paramsGoToGeneral(ActionEvent event) {
        moveDisplay(affichageParams,0.0,0.0,actuelParam,btnGeneral);
        actuelParam=btnGeneral;
    }

    @FXML
    void paramsGoToGeneralApparence(ActionEvent event) {
        moveDisplay(generalAffichage,0.0,0.0,actuelSubParam1,btnApparence);
        actuelSubParam1=btnApparence;
    }

    @FXML
    void changeColorMode(ActionEvent event) {
        if(sombre){
            sombre=false;
            root.getStylesheets().remove(1);
        }else {
            sombre=true;
            root.getStylesheets().add(this.getClass().getResource("Ressources\\CSS\\DarkStyle.css").toExternalForm());
        }
        updateUI();
        transitionPage(history.get(indexHistory-1),history.get(indexHistory),false);
        prefFileMAJ();
    }
    
    @FXML
    void paramsGoToGeneralRaccourcie(ActionEvent event) {
        moveDisplay(generalAffichage,-400.0,0.0,actuelSubParam1,btnRaccourcie);
        actuelSubParam1=btnRaccourcie;
    }

    @FXML
    void limitLengthRaccourcieDeco(KeyEvent event) {
        limitLengthField(raccourcieFieldDeco,1);
    }

    @FXML
    void setRaccourcieDeco(ActionEvent event) {
        if(!raccourcieFieldDeco.getText().equals("")) {
            setRaccourcie(listCtrlDeco.getSelectionModel().getSelectedItem().toString(), raccourcieFieldDeco.getText(), 0);
        }
    }

    @FXML
    void limitLengthRaccourciePagePrec(KeyEvent event) {
        limitLengthField(raccourcieFieldPagePrec,1);
    }

    @FXML
    void setRaccourciePagePrec(ActionEvent event) {
        if(!raccourcieFieldPagePrec.getText().equals("")) {
            setRaccourcie(listCtrlPagePrec.getSelectionModel().getSelectedItem().toString(), raccourcieFieldPagePrec.getText(), 1);
        }
    }
    
    @FXML
    void limitLengthRaccourciePageSuiv(KeyEvent event) {
        limitLengthField(raccourcieFieldPageSuiv,1);
    }

    @FXML
    void setRaccourciePageSuiv(ActionEvent event) {
        if(!raccourcieFieldPageSuiv.getText().equals("")) {
            setRaccourcie(listCtrlPageSuiv.getSelectionModel().getSelectedItem().toString(), raccourcieFieldPageSuiv.getText(), 2);
        }
    }

    void setRaccourcie(String k1, String k2, int i) {
        char chr=k2.charAt(0);
        chr=Character.toUpperCase(chr);
        k2=Character.toString(chr);
        Boolean ok=true;
        for(String [] s: shortcuts) {
            if(s[0].equals(k1)&&s[1].equals(k2)) {ok=false;}
        }
        if(ok) {
            shortcuts.get(i)[0]=k1;
            shortcuts.get(i)[1]=k2;
            actionConfirmed();
            prefFileMAJ();
        }else {
            actionRefused();
        }
    }
    
    void limitLengthField(TextField f, int n) {
        if(f.getText().length()>n) {
            f.setText(f.getText().substring(0, 1));
        }else {
            if(!Pattern.matches("[a-zA-Z]*", f.getText())) {
                f.setText("");
            }
        }
    }
    
    @FXML
    void paramsGoToGeneralSecurite(ActionEvent event) {
        moveDisplay(generalAffichage,-800.0,0.0,actuelSubParam1,btnSecurite);
        actuelSubParam1=btnSecurite;
        mdpAncienFieldParam.requestFocus();
    }

    @FXML
    void changeMdp(ActionEvent event) throws SQLException {
        if(bdd.connexion(idFieldParam.getText(), mdpAncienFieldParam.getText())) {
            if(mdpNouveauFieldParam.getText().equals(mdpNouveauConfirmFieldParam.getText())) {
                int id=bdd.getEmployeId(idFieldParam.getText());
                bdd.update("password='"+mdpNouveauFieldParam.getText()+"'", "employe", id, 0);
                mdpAncienFieldParam.setText("");
                mdpNouveauFieldParam.setText("");
                mdpNouveauConfirmFieldParam.setText("");
                actionConfirmed();
            }else {
                actionRefused();
            }
        }else {
            actionRefused();
        }
    }

    @FXML
    void paramsGoToMySQL(ActionEvent event) {
        moveDisplay(affichageParams,0.0,-476.0,actuelParam,btnMySQL);
        actuelParam=btnMySQL;
    }

    @FXML
    void changeServeurMySQLIP(ActionEvent event) {
        if(!mysqlServeurIP.getText().equals("")) {
            prefFileMAJ();
            actionConfirmed();
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void changeServeurMySQLPort(ActionEvent event) {
        if(!mysqlServeurPort.getText().equals("")) {
            prefFileMAJ();
            actionConfirmed();
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void changeDatabaseName(ActionEvent event) {
        if(!baseNom.getText().equals("")) {
            prefFileMAJ();
            actionConfirmed();
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void paramsGoToAide(ActionEvent event) {
        moveDisplay(affichageParams,0.0,-952.0,actuelParam,btnAide);
        actuelParam=btnAide;
    }
    
    @FXML
    void paramsGoToAideUtilisation(ActionEvent event) {
        moveDisplay(aideAffichage,0.0,0.0,actuelSubParam3,btnAideUtilisation);
        actuelSubParam3=btnAideUtilisation;
    }

    @FXML
    void goToAide(ActionEvent event) {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start https://drive.google.com/file/d/1655z0R7kD4TpEE7eI56C7QEyIuGBj7z4/view?usp=sharing"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void paramsGoToAideCredits(ActionEvent event) {
        moveDisplay(aideAffichage,-400.0,0.0,actuelSubParam3,btnAideCredits);
        actuelSubParam3=btnAideCredits;
    }

    @FXML
    void deconnection(ActionEvent event) {
        lock();
    }

//Personne
    @FXML
    void displayPersonne(ActionEvent event) throws SQLException {
        transitionPage(mainUI,personne,true);
        if(actuelPersonne==personneAjouterB) {
            personneGoToRechercher(new ActionEvent());
        }else {
            ArrayList<ArrayList<String>> filters=getFilters(personneFiltreContenu);
            ArrayList<Cellule> data=bdd.searchToTableView("competiteur", filters);
            personneDisplayResultT.setItems(getObservableList(data));
            history.clear();
            indexHistory=1;
            history.add(mainUI);
            history.add(personne);
        }
    }
    
    @FXML
    void addFiltrePrenom(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltrePrenomB);
    }
    
    @FXML
    void addFiltreNom(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreNomB);
    }
    
    @FXML
    void addFiltreDate(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreDateB);
    }
    
    @FXML
    void addFiltreEmail(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreEmailB);
    }
    
    @FXML
    void addFiltreSexe(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreSexeB);
    }
    
    @FXML
    void addFiltreVille(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreVilleB);
    }
    
    @FXML
    void addFiltreEquipe(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreEquipeB);
    }
    
    @FXML
    void addFiltreSport(ActionEvent event) {
        addFiltre(personneFiltreContenu, personneFiltreSportB);
    }

    @FXML
    void personneGoToRechercher(ActionEvent event) throws SQLException {
        lancerRecherche(personne,personneContentGauche,personneContentDroite,actuelPersonne,personneRechercheB,personneFiltreContenu,personneDisplayResultT,"competiteur");
    }
    
    @FXML
    void personneGoToAjouter(ActionEvent event) throws SQLException {
        ArrayList out=lancerAjout(personne, personneAjouterChampsContenu, toogleAddPersonne, actuelPersonne, personneAjouterB, personneContentGauche, personneContentDroite);
        if((Boolean)out.get(0)) {
            Map<String, String> data=(Map<String, String>)out.get(1);
            toogleAddPersonne=true;
            String dataS="('"+data.get("prenom")+"','"+data.get("nom")+"','"+data.get("sexe")+"','"+data.get("date_naissance")+"','"+data.get("email")+"',";
            if(!bdd.exists("nom='"+data.get("id_ville")+"'", "ville")) {
                bdd.add("('"+data.get("id_ville")+"')", "ville");
            }
            if(!bdd.exists("libelle='"+data.get("id_sport")+"'", "sport")) {
                bdd.add("('"+data.get("id_sport")+"')", "sport");
            }
            dataS+="(select id_ville from ville where nom='"+data.get("id_ville")+"'), (select id_sport from sport where libelle='"+data.get("id_sport")+"'))";
            bdd.add(dataS, "competiteur");
            setCategoriesBDD();
            actionConfirmed();
            indexElementAdded=bdd.getMaxId("competiteur", "id_competiteur");
        }
    }

    void showCompetiteur(int id) throws SQLException {
        ArrayList infos=bdd.searchFromId("competiteur", id, 0);
        if(infos.size()!=0) {
            modificationCompetiteurPrenom.setText((String) infos.get(0));
            modificationCompetiteurNom.setText((String) infos.get(1));
            modificationCompetiteurSexe.setText((String) infos.get(2));
            modificationCompetiteurEmail.setText((String) infos.get(3));
            modificationCompetiteurDate.setText((String) infos.get(4));
            modificationCompetiteurVille.setText((String) infos.get(5));
            modificationCompetiteurSport.setText((String) infos.get(6));
            modificationCompetiteurEquipe.setText((String) infos.get(7));
        }
    }

    @FXML
    void modificationCompetiteurGoToEquipe(ActionEvent event) throws SQLException {
        if(modificationCompetiteurEquipe.getText().equals("→ Equipes")) {
            history.add(equipe);
            indexHistory++;
            transitionPage(modificationCompetiteur,equipe,true);
        }else {
            if(history.get(history.size()-2).equals(modificationEquipe)) {
                historyBack(new ActionEvent());
            }else {
                Object o=personneDisplayResultT.getSelectionModel().getSelectedItem();
                int id=((Cellule)o).getId();
                history.add(modificationEquipe);
                indexHistory++;
                int id_equipe=bdd.getEquipeId(id);
                showEquipe(id_equipe);
                ArrayList<Cellule> data=new ArrayList<Cellule>();
                Cellule equipe=new Cellule("","",id_equipe);
                data.add(equipe);
                equipeDisplayResultT.setItems(getObservableList(data));
                equipeDisplayResultT.getSelectionModel().select(equipe);
                transitionPage(modificationCompetiteur,modificationEquipe,true);
            }
        }
    }
    
    @FXML
    void personneAddNouvelle(ActionEvent event) {
        addNouvelleBtn(toogleAddPersonne,personneAjouterChampsContenu);
    }
    
    @FXML
    void personneAddSupprimer(ActionEvent event) throws SQLException {
        addSupprimerBtn(toogleAddPersonne,"competiteur");
    }

    @FXML
    void personneAddModifier(ActionEvent event) throws SQLException {
        if(indexElementAdded!=0&&toogleAddPersonne) {
            modificationBtn(indexElementAdded,"competiteur");
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void modificationCompetiteurModify(ActionEvent event) throws SQLException {
        Object o=personneDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        modificationBtn(id,"competiteur");
    }

    @FXML
    void modificationCompetiteurDelete(ActionEvent event) throws SQLException {
        Object o=personneDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        if(history.get(history.size()-2).equals(modificationEquipe)) {
            modifySupprimerBtn(id,"competiteur",modificationCompetiteur,modificationEquipe);
            modificationMAJ(equipeDisplayResultT,equipeModificationFiltreContenu,"id_equipe ","0","equipe","sexe","competiteur",equipeModificationDisplayResultTBottom,equipeModificationDisplayResultTTop,"equipe.competiteur");
        }else {
            modifySupprimerBtn(id,"competiteur",modificationCompetiteur,personne);
        }
    }

    @FXML
    void personneAddGoToEquipe(ActionEvent event) throws SQLException {
        if(indexElementAdded!=0) {
            history.add(equipe);
            indexHistory++;
            ArrayList<ArrayList<String>> filters=getFilters(equipeFiltreContenu);
            ArrayList<Cellule> data=bdd.searchToTableView("equipe", filters);
            equipeDisplayResultT.setItems(getObservableList(data));
            transitionPage(personne,equipe,true);
        }else {
            actionRefused();
        }
        
    }

//Equipe
    void showEquipe(int id) throws SQLException {
        ArrayList infos=bdd.searchFromId("equipe", id, 0);
        if(infos.size()!=0) {
            modificationEquipeNom.setText((String) infos.get(0));
            modificationEquipeType.setText((String) infos.get(1));
            modificationEquipeVille.setText((String) infos.get(2));
            modificationEquipeSport.setText((String) infos.get(3));
        }
    }

    @FXML
    void modificationEquipeModify(ActionEvent event) throws SQLException {
        Object o=equipeDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        modificationBtn(id,"equipe");
    }

    @FXML
    void displayEquipe(ActionEvent event) throws SQLException {
        transitionPage(mainUI,equipe,true);
        ArrayList<ArrayList<String>> filters=getFilters(equipeFiltreContenu);
        ArrayList<Cellule> data=bdd.searchToTableView("equipe", filters);
        equipeDisplayResultT.setItems(getObservableList(data));
        history.clear();
        indexHistory=1;
        history.add(mainUI);
        history.add(equipe);
    }
    
    @FXML
    void equipeGoToRechercher(ActionEvent event) throws SQLException {
        lancerRecherche(equipe,equipeContentGauche,equipeContentDroite,actuelEquipe,equipeRechercheB,equipeFiltreContenu,equipeDisplayResultT,"equipe");
    }

    @FXML
    void modificationEquipeDelete(ActionEvent event) throws SQLException {
        Object o=equipeDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        bdd.update("null", "reset.equipe", id, 0);
        modifySupprimerBtn(id,"equipe",modificationEquipe,equipe);
    }

    @FXML
    void equipeGoToAjouter(ActionEvent event) throws SQLException {
        ArrayList out=lancerAjout(equipe,equipeAjouterChampsContenu,toogleAddEquipe,actuelEquipe,equipeAjouterB,equipeContentGauche,equipeContentDroite);
        if((Boolean)out.get(0)) {
            Map<String, String> data=(Map<String, String>)out.get(1);
            toogleAddEquipe=true;
            String dataS="('"+data.get("nom")+"','"+data.get("type")+"',";
            if(!bdd.exists("nom='"+data.get("id_ville")+"'", "ville")) {
                bdd.add("('"+data.get("id_ville")+"')", "ville");
            }
            if(!bdd.exists("libelle='"+data.get("id_sport")+"'", "sport")) {
                bdd.add("('"+data.get("id_sport")+"')", "sport");
            }
            dataS+="(select id_ville from ville where nom='"+data.get("id_ville")+"'), (select id_sport from sport where libelle='"+data.get("id_sport")+"'))";
            bdd.add(dataS, "equipe");
            setCategoriesBDD();
            actionConfirmed();
            indexElementAdded=bdd.getMaxId("equipe", "id_equipe");
        }
    }

    @FXML
    void equipeAddFiltreNom(ActionEvent event) {
        addFiltre(equipeFiltreContenu, equipeFiltreNomB);
    }
    
    @FXML
    void equipeAddFiltreType(ActionEvent event) {
        addFiltre(equipeFiltreContenu, equipeFiltreTypeB);
    }
    
    @FXML
    void equipeAddFiltreVille(ActionEvent event) {
        addFiltre(equipeFiltreContenu, equipeFiltreVilleB);
    }
    
    @FXML
    void equipeAddFiltreSport(ActionEvent event) {
        addFiltre(equipeFiltreContenu, equipeFiltreSportB);
    }
    
    @FXML
    void equipeAddNouvelle(ActionEvent event) {
        addNouvelleBtn(toogleAddEquipe, equipeAjouterChampsContenu);
    }

    @FXML
    void equipeAddModifier(ActionEvent event) throws SQLException {
        modificationBtn(indexElementAdded,"equipe");
    }
    
    @FXML
    void equipeAddSupprimer(ActionEvent event) throws SQLException {
        addSupprimerBtn(toogleAddEquipe,"equipe");
    }
    
    @FXML
    void modificationEquipeGoToOtherPart(ActionEvent event) throws SQLException {
        goToOtherPartBtn(modificationEquipeC,modificationEquipeContent,modificationEquipeContentBtn,toogleModificationEquipe,equipeDisplayResultT,equipeModificationLabelSexe,equipeModificationFiltreSexe,equipeModificationFiltreSexeB,"Paramètres de l'équipe","Compétiteurs de l'équipe");
    }

    @FXML
    void equipeModificationAddFiltrePrenom(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltrePrenomB);
    }
    
    @FXML
    void equipeModificationAddFiltreNom(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltreNomB);
    }
    
    @FXML
    void equipeModificationAddFiltreDateNaissance(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltreDateNaissanceB);
    }
    
    @FXML
    void equipeModificationAddFiltreEmail(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltreEmailB);
    }
    
    @FXML
    void equipeModificationAddFiltreVille(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltreVilleB);
    }
    
    @FXML
    void equipeModificationAddFiltreSexe(ActionEvent event) {
        addFiltre(equipeModificationFiltreContenu, equipeModificationFiltreSexeB);
    }

    @FXML
    void equipeModificationRechercherBtn(ActionEvent event) throws SQLException {
        modificationMAJ(equipeDisplayResultT,equipeModificationFiltreContenu,"id_equipe ","0","equipe","sexe","competiteur",equipeModificationDisplayResultTBottom,equipeModificationDisplayResultTTop,"equipe.competiteur");
    }

    @FXML
    void equipeModificationAddDeleteB(ActionEvent event) throws SQLException {
        Object o=equipeDisplayResultT.getSelectionModel().getSelectedItem();
        int id_equipe=((Cellule)o).getId();
        Cellule e1=equipeModificationDisplayResultTTop.getSelectionModel().getSelectedItem();
        Cellule e2=equipeModificationDisplayResultTBottom.getSelectionModel().getSelectedItem();
        if(e1!=null||e2!=null) {
            if(e1==null) {
                int id=e2.getId();
                bdd.update("id_equipe="+id_equipe, "competiteur", id, 0);
            }else {
                int id=e1.getId();
                bdd.update("id_equipe=0", "competiteur", id, 0);
            }
            modificationMAJ(equipeDisplayResultT,equipeModificationFiltreContenu,"id_equipe ","0","equipe","sexe","competiteur",equipeModificationDisplayResultTBottom,equipeModificationDisplayResultTTop,"equipe.competiteur");
            actionConfirmed();
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void equipeModificationDetailsPersonne(ActionEvent event) throws SQLException {
        Cellule e1=equipeModificationDisplayResultTTop.getSelectionModel().getSelectedItem();
        Cellule e2=equipeModificationDisplayResultTBottom.getSelectionModel().getSelectedItem();
        if(e1!=null||e2!=null) {
            int id;
            if(e1==null) {
                id=e2.getId();
            }else {
                id=e1.getId();
            }
            indexHistory=3;
            showCompetiteur(id);
            transitionPage(modificationEquipe,modificationCompetiteur,true);
            history.clear();
            history.add(mainUI);
            history.add(equipe);
            history.add(modificationEquipe);
            history.add(modificationCompetiteur);
        }else {
            actionRefused();
        }
    }

//Historique
    @FXML
    void displayHistorique(ActionEvent event) throws SQLException {
        Object o=equipeDisplayResultT.getSelectionModel().getSelectedItem();
        equipeModificationHistoriqueResultatsTable.setItems(getObservableList(bdd.getCompetitionsForTeam(((Cellule)o).getId(), "")));
        transitionPage(modificationEquipe,equipeModificationHistoriquePage,true);
        history.clear();
        history.add(mainUI);
        history.add(equipe);
        history.add(modificationEquipe);
        history.add(equipeModificationHistoriquePage);
        indexHistory++;
    }
    
    @FXML
    void equipeModificationHistoriqueLancerRecherche(ActionEvent event) throws SQLException {
        String date_debut=equipeModificationHistoriqueDateDebut.getText();
        String date_fin=equipeModificationHistoriqueDateFin.getText();
        String dates="";
        if(!date_debut.equals("")||!date_fin.equals("")) {
            dates=" and ";
            if(!date_debut.equals("")) {
                dates+="competition.date_debut>='"+date_debut+"'";
                if(!date_fin.equals("")) {
                    dates+=" and ";
                }
            }
            if(!date_fin.equals("")) {
                dates+="competition.date_fin<='"+date_fin+"'";
            }
        }
        Object o=equipeDisplayResultT.getSelectionModel().getSelectedItem();
        equipeModificationHistoriqueResultatsTable.setItems(getObservableList(bdd.getCompetitionsForTeam(((Cellule)o).getId(), dates)));
    }

//Compétition
    void showCompetition(int id) throws SQLException {
        ArrayList infos=bdd.searchFromId("competition", id, 0);
        if(infos.size()!=0) {
            modificationCompetitionLibelle.setText((String) infos.get(0));
            modificationCompetitionType.setText((String) infos.get(1));
            modificationCompetitionVille.setText((String) infos.get(2));
            modificationCompetitionSport.setText((String) infos.get(3));
            modificationCompetitionDateDebut.setText((String) infos.get(4));
            modificationCompetitionDateFin.setText((String) infos.get(5));
        }
    }

    @FXML
    void displayCompetition(ActionEvent event) throws SQLException {
        transitionPage(mainUI,competition,true);
        if(actuelCompetition==competitionAjouterB) {
            competitionGoToRechercher(new ActionEvent());
        }else {
            ArrayList<ArrayList<String>> filters=getFilters(competitionFiltreContenu);
            ArrayList<Cellule> data=bdd.searchToTableView("competition", filters);
            competitionDisplayResultT.setItems(getObservableList(data));
            history.clear();
            indexHistory=1;
            history.add(mainUI);
            history.add(competition);
        }
    }
    
    @FXML
    void competitionGoToRechercher(ActionEvent event) throws SQLException {
        lancerRecherche(competition,competitionContentGauche,competitionContentDroite,actuelCompetition,competitionRechercheB,competitionFiltreContenu,competitionDisplayResultT,"competition");
    }
    
    @FXML
    void competitionGoToAjouter(ActionEvent event) throws SQLException {
        ArrayList out=lancerAjout(competition,competitionAjouterChampsContenu,toogleAddCompetition,actuelCompetition,competitionAjouterB,competitionContentGauche,competitionContentDroite);
        if((Boolean)out.get(0)) {
            Map<String, String> data=(Map<String, String>)out.get(1);
            toogleAddCompetition=true;
            String dataS="('"+data.get("libelle")+"','"+data.get("type")+"','"+data.get("date_debut")+"','"+data.get("date_fin")+"',";
            if(!bdd.exists("nom='"+data.get("id_ville")+"'", "ville")) {
                bdd.add("('"+data.get("id_ville")+"')", "ville");
            }
            if(!bdd.exists("libelle='"+data.get("id_sport")+"'", "sport")) {
                bdd.add("('"+data.get("id_sport")+"')", "sport");
            }
            dataS+="(select id_ville from ville where nom='"+data.get("id_ville")+"'), (select id_sport from sport where libelle='"+data.get("id_sport")+"'))";
            bdd.add(dataS, "competition");
            setCategoriesBDD();
            actionConfirmed();
            indexElementAdded=bdd.getMaxId("competition", "id_competition");
        }
    }
    
    @FXML
    void competitionAddFiltreLibelle(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreLibelleB);
    }
    
    @FXML
    void competitionAddFiltreSport(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreSportB);
    }
    
    @FXML
    void competitionAddFiltreVille(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreVilleB);
    }
    
    @FXML
    void competitionAddFiltreType(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreTypeB);
    }
    
    @FXML
    void competitionAddFiltreDateDebut(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreDateDebutB);
    }
    
    @FXML
    void competitionAddFiltreDateFin(ActionEvent event) {
        addFiltre(competitionFiltreContenu, competitionFiltreDateFinB);
    }
    
    @FXML
    void competitionAddNouvelle(ActionEvent event) {
        addNouvelleBtn(toogleAddCompetition,competitionAjouterChampsContenu);
    }
    
    @FXML
    void competitionAddModifier(ActionEvent event) throws SQLException {
        modificationBtn(indexElementAdded,"competition");
    }
    
    @FXML
    void competitionAddSupprimer(ActionEvent event) throws SQLException {
        addSupprimerBtn(toogleAddCompetition,"competition");
    }
    
    @FXML
    void competitionModificationAddFiltreNom(ActionEvent event) {
        addFiltre(competitionModificationFiltreContenu, competitionModificationFiltreNomB);
    }
    
    @FXML
    void competitionModificationAddFiltreVille(ActionEvent event) {
        addFiltre(competitionModificationFiltreContenu, competitionModificationFiltreVilleB);
    }
    
    @FXML
    void competitionModificationAddFiltreType(ActionEvent event) {
        addFiltre(competitionModificationFiltreContenu, competitionModificationFiltreTypeB);
    }
    
    @FXML
    void competitionModificationRechercherBtn(ActionEvent event) throws SQLException {
        Object o=competitionDisplayResultT.getSelectionModel().getSelectedItem();
        int id=((Cellule)o).getId();
        modificationMAJ(competitionDisplayResultT,competitionModificationFiltreContenu,"id_equipe","(select inscription_equipe.id_equipe from inscription_equipe where inscription_equipe.id_competition="+id+" union select inscription_equipe.id_equipe from inscription_equipe, competition where competition.id_competition=inscription_equipe.id_competition and competition.date_debut >= (select date_debut from competition where id_competition="+id+") and competition.date_fin <= (select date_fin from competition where id_competition="+id+"))","competition","type","equipe",competitionModificationDisplayResultTBottom,competitionModificationDisplayResultTTop,"competition.equipe");
    }
    
    @FXML
    void modificationCompetitionModify(ActionEvent event) throws SQLException {
        Object o;
        if(history.contains(equipeModificationHistoriquePage)) {
            o=equipeModificationHistoriqueResultatsTable.getSelectionModel().getSelectedItem();
        }else {
            o=competitionDisplayResultT.getSelectionModel().getSelectedItem();
        }
        int id=((Cellule)o).getId();
        modificationBtn(id,"competition");
    }
    
    @FXML
    void modificationCompetitionDelete(ActionEvent event) throws SQLException {
        Object o;
        if(history.contains(equipeModificationHistoriquePage)) {
            o=equipeModificationHistoriqueResultatsTable.getSelectionModel().getSelectedItem();
        }else {
            o=competitionDisplayResultT.getSelectionModel().getSelectedItem();
        }
        int id=((Cellule)o).getId();
        bdd.remove("reset.inscription", id, 0);
        modifySupprimerBtn(id,"competition",modificationCompetition,competition);
    }
    
    @FXML
    void modificationCompetitionGoToOtherPart(ActionEvent event) throws SQLException {
        Object o;
        if(history.contains(equipeModificationHistoriquePage)) {
            goToOtherPartBtn(modificationCompetitionE,modificationCompetitionContent,modificationCompetitionContentBtn,toogleModificationCompetition,equipeModificationHistoriqueResultatsTable,competitionModificationLabelType,competitionModificationFiltreType,competitionModificationFiltreTypeB,"Paramètres de compétition","Inscription des équipes");
        }else {
            goToOtherPartBtn(modificationCompetitionE,modificationCompetitionContent,modificationCompetitionContentBtn,toogleModificationCompetition,competitionDisplayResultT,competitionModificationLabelType,competitionModificationFiltreType,competitionModificationFiltreTypeB,"Paramètres de compétition","Inscription des équipes");

        }
    }
    
    @FXML
    void competitionModificationAddDeleteB(ActionEvent event) throws SQLException {
        Object o;
        if(history.contains(equipeModificationHistoriquePage)) {
            o=equipeModificationHistoriqueResultatsTable.getSelectionModel().getSelectedItem();
        }else {
            o=competitionDisplayResultT.getSelectionModel().getSelectedItem();
        }
        int id_competition=((Cellule)o).getId();
        if(!bdd.started(id_competition)) {
            Cellule e1=competitionModificationDisplayResultTTop.getSelectionModel().getSelectedItem();
            Cellule e2=competitionModificationDisplayResultTBottom.getSelectionModel().getSelectedItem();
            if(e1!=null||e2!=null) {
                if(e1==null) {
                    int id=e2.getId();
                    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    bdd.add("("+id_competition+","+id+",'"+formatter.format(date)+"')","inscription_equipe");
                }else {
                    int id=e1.getId();
                    bdd.remove("inscription_equipe",id_competition,id);
                }
                modificationMAJ(competitionDisplayResultT,competitionModificationFiltreContenu,"id_equipe","(select inscription_equipe.id_equipe from inscription_equipe where inscription_equipe.id_competition="+id_competition+" union select inscription_equipe.id_equipe from inscription_equipe, competition where competition.id_competition=inscription_equipe.id_competition and competition.date_debut >= (select date_debut from competition where id_competition="+id_competition+") and competition.date_fin <= (select date_fin from competition where id_competition="+id_competition+"))","competition","type","equipe",competitionModificationDisplayResultTBottom,competitionModificationDisplayResultTTop,"competition.equipe");
                actionConfirmed();
            }else {
                actionRefused();
            }
        }else {
            actionRefused();
        }
    }
    
    @FXML
    void competitionModificationDetailsEquipe(ActionEvent event) throws SQLException {
        Cellule e1=competitionModificationDisplayResultTTop.getSelectionModel().getSelectedItem();
        Cellule e2=competitionModificationDisplayResultTBottom.getSelectionModel().getSelectedItem();
        if(e1!=null||e2!=null) {
            int id;
            if(e1==null) {
                id=e2.getId();
            }else {
                id=e1.getId();
            }
            indexHistory=3;
            showEquipe(id);
            transitionPage(modificationCompetition,modificationEquipe,true);
            history.clear();
            history.add(mainUI);
            history.add(competition);
            history.add(modificationCompetition);
            history.add(modificationEquipe);
        }else {
            actionRefused();
        }
    }

//Général
    @FXML
    void nextField(ActionEvent event) {
    	TextField field=(TextField)event.getSource();
    	String style,style2="-fx-background-radius: 3;-fx-border-radius: 3;-fx-border-width: 0.5;-fx-border-color: black;";
    	if(!sombre) {
    		style="-fx-border-width: 0;-fx-background-color: white;-fx-text-fill: black;";
    		if(!field.getParent().getStyleClass().get(0).toString().equals("page")) {style+=style2;}
    		field.setStyle(style);
    	}else {
    		style="-fx-border-width: 0;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;";
    		if(!field.getParent().getStyleClass().get(0).toString().equals("page")) {style+=style2;}
    		field.setStyle(style);
    	}
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
    
    void fieldMove(Node field) {
    	TranslateTransition t=new TranslateTransition(Duration.millis(100), field);
    	t.setToX(8);
    	t.play();
    	t.setOnFinished(e -> {
    		t.setToX(-12);
    		t.play();
    		t.setOnFinished(e1 -> {
    			t.setToX(8);
    			t.play();
    			t.setOnFinished(e2 -> {
    				t.setToX(-6);
    				t.play();
    				t.setOnFinished(e3 -> {
    					t.setToX(4);
    					t.play();
    					t.setOnFinished(e4 -> {
    						t.setToX(-2);
    						t.play();
    						t.stop();
    					});
    				});
    			});
    		});
    	});
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
	
	void refreshShortcuts() {
		//Liste de champs (lettres)
		ArrayList<TextField> letters=new ArrayList<TextField>();
		letters.add(raccourcieFieldDeco);
		letters.add(raccourcieFieldPagePrec);
		letters.add(raccourcieFieldPageSuiv);
		
		//Liste de champs (Ctrl)
		ArrayList<ListView>listList=new ArrayList<ListView>();
		listList.add(listCtrlDeco);
		listList.add(listCtrlPagePrec);
		listList.add(listCtrlPageSuiv);
		
		//Mise à jour des paramètres
		for(int i=0;i<listList.size();i++) {
			listList.get(i).getItems().clear();
			listList.get(i).setFixedCellSize(30);
			Label s=new Label(shortcuts.get(i)[0]);
			s.setFont(Font.font("Candara Light"));
			s.setMinHeight(30);
			listList.get(i).getItems().add(s.getText());
			if(!shortcuts.get(i)[0].equals("   Alt")) {
				s.setText("   Alt");
				listList.get(i).getItems().add(s.getText());
			}
			if(!shortcuts.get(i)[0].equals("   Maj")) {
				s.setText("   Maj");
				listList.get(i).getItems().add(s.getText());
			}
			if(!shortcuts.get(i)[0].equals("   Ctrl")) {
				s.setText("   Ctrl");
				listList.get(i).getItems().add(s.getText());
			}
			listList.get(i).getSelectionModel().select(0);
			letters.get(i).setText(shortcuts.get(i)[1]);
			listList.get(i).scrollTo(0);
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
		if((p2.equals((Node)mainUI)||p2.equals((Node)parametre)&&annimMenu)) {
			ArrayList<Node>btns=new ArrayList<Node>();
			if(p2.equals((Node)mainUI)){
				for(Node n:mainUI.getChildren()) {if(n instanceof Button) {btns.add(n);}}
			}else if(p2.equals((Node)parametre)){
				for(Node n:parametre.getChildren()) {if(n instanceof Button) {btns.add(n);}}
			}
			btns.remove(0);
			for(Node btn:btns) {btn.setTranslateY(0);}
			tp2.setOnFinished(e -> {
				int i=1;
				for(Node btn: btns) {
					TranslateTransition tb=new TranslateTransition(Duration.millis(i*250), btn);
					tb.setToY(i*125);
					tb.play();
					i++;
				}
			});
		}
		tp1.play();
		tp2.play();
	}
	
	void lock() {
		logo.setVisible(true);
		Node page=null;
		for(Node node: background.getChildren()) {
			if(node instanceof Pane&&node.isVisible()) {
				page=node;
				break;
			}
		}
		if(page!=null) {
			transitionPage(page,logo,true);
			history.clear();
		}
	}
	
	void moveDisplay(Node element, Double x, Double y, Button b1, Button b2) {
		TranslateTransition tt=new TranslateTransition(Duration.millis(500), element);
		tt.setToX(x);
		tt.setToY(y);
		tt.play();
		if(!sombre) {
			b1.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-cursor: hand;");
			b2.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;-fx-cursor: hand;");
		}else {
			b1.setStyle("-fx-background-color: rgb(125,125,125);-fx-text-fill: white;-fx-cursor: hand;");
			b2.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;-fx-cursor: hand;");
		}
	}
	
	void updateUI() {
		String fieldStyle,btnStyle,paneStyle,labelStyle,fieldStyle_menu,btnStyle_menu;
		if(sombre) {
			changeMode.setText("On");
			fieldStyle="-fx-padding: 5 10 5 10;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;";
			fieldStyle_menu="-fx-padding: 5 10 5 10;-fx-background-color: rgb(125,125,125);-fx-text-fill: white;-fx-background-radius: 3;-fx-border-radius: 3;-fx-border-width: 0.5;-fx-border-color: black;";
			btnStyle="-fx-background-color: rgb(125,125,125);-fx-cursor: hand;-fx-text-fill: white;";
			btnStyle_menu="-fx-background-color: rgb(125,125,125);-fx-text-fill: white;-fx-border-width: 0.5;-fx-border-color: black;-fx-background-radius: 3;-fx-border-radius: 3;";
			paneStyle="-fx-background-color: rgb(125,125,125);-fx-text-fill: white;";
			labelStyle="-fx-text-fill: white;";
		}else {
			changeMode.setText("Off");
			fieldStyle="-fx-padding: 5 10 5 10;-fx-background-color: white;-fx-text-fill: black;";
			fieldStyle_menu="-fx-padding: 5 10 5 10;-fx-background-color: white;-fx-text-fill: black;-fx-background-radius: 3;-fx-border-radius: 3;-fx-border-width: 0.5;-fx-border-color: black;";
			btnStyle="-fx-background-color: white;-fx-cursor: hand;-fx-text-fill: black;";
			btnStyle_menu="-fx-background-color: white;-fx-text-fill: black;-fx-border-width: 0.5;-fx-border-color: black;-fx-background-radius: 3;-fx-border-radius: 3;";
			paneStyle="-fx-background-color: white;-fx-text-fill: black;";
			labelStyle="-fx-text-fill: black;";
		}
		
		ArrayList<Node> nodes=getNodes(root.getChildren());
		
		for(Node n:nodes) {
			if(n instanceof Button) {
				if(n.getParent().getStyleClass().get(0).toString().equals("page")||n.getParent().getStyleClass().get(0).toString().equals("pageT")) {n.setStyle(btnStyle);}
				else {n.setStyle(btnStyle_menu);}
			}else if(n instanceof Label) {
				if(!n.getParent().getStyleClass().get(0).equals("page")&&!n.getParent().getStyleClass().get(0).equals("pageT")) {
					n.setStyle(labelStyle);
				}
			}else if(n instanceof Pane||n instanceof ScrollPane) {
				if(!n.getStyleClass().get(0).equals("page")&&!n.getStyleClass().get(0).equals("pageT")) {
					n.setStyle(paneStyle);
				}
			}else if(n instanceof TextField) {
				if(n.getParent().getStyleClass().get(0).toString().equals("page")) {n.setStyle(fieldStyle);}
				else {n.setStyle(fieldStyle_menu);}
			}
		}
		
		actuelParam.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelSubParam1.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelSubParam2.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelSubParam3.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelPersonne.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelEquipe.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
		actuelCompetition.setStyle("-fx-background-color: rgb(150,150,150);-fx-text-fill: white;");
	}
	
	ArrayList<Node> getNodes(ObservableList<Node> childrens){
		ArrayList<Node> nodes=new ArrayList<Node>();
		for(Node n: childrens) {
			if(n instanceof Pane) {
				String styleClass=n.getStyleClass().get(0);
				if(!styleClass.equals("fond")) {
					if(!styleClass.equals("page")&&!styleClass.equals("pageT")) {
						nodes.add(n);
					}
					nodes.addAll(getNodes(((Pane)n).getChildren()));
				}
			}else if(n instanceof Button) {
				String styleClass=n.getStyleClass().get(1);
				if(!styleClass.equals("historyBtn")&&!styleClass.equals("btnM")) {
					nodes.add(n);
				}
			}else if(n instanceof TextField||n instanceof PasswordField||n instanceof Label) {
				nodes.add(n);
			}else if(n instanceof ScrollPane) {
				String styleClass=n.getStyleClass().get(1);
				if(!styleClass.equals("page")&&!styleClass.equals("pageT")) {
					nodes.add(n);
				}
				if(n.equals(personneFiltresCadre)) {
					nodes.add(personneFiltreContenu);
					nodes.addAll(personneFiltreContenu.getChildren());
				}else if(n.equals(modificationCompetiteurCadre)) {
					nodes.add(modificationCompetiteurContenu);
					nodes.addAll(modificationCompetiteurContenu.getChildren());
				}else if(n.equals(equipeFiltresCadre)) {
					nodes.add(equipeFiltreContenu);
					nodes.addAll(equipeFiltreContenu.getChildren());
				}else if(n.equals(modificationEquipeCadreTop)) {
					nodes.add(modificationEquipeContenu);
					nodes.addAll(modificationEquipeContenu.getChildren());
				}else if(n.equals(equipeModificationFiltresCadre)) {
					nodes.add(equipeModificationFiltreContenu);
					nodes.addAll(equipeModificationFiltreContenu.getChildren());
				}else if(n.equals(competitionFiltresCadre)) {
					nodes.add(competitionFiltreContenu);
					nodes.addAll(competitionFiltreContenu.getChildren());
				}else if(n.equals(modificationCompetitionCadreTop)) {
					nodes.add(modificationCompetitionContenu);
					nodes.addAll(modificationCompetitionContenu.getChildren());
				}else if(n.equals(competitionModificationFiltresCadre)) {
					nodes.add(competitionModificationFiltreContenu);
					nodes.addAll(competitionModificationFiltreContenu.getChildren());
				}
			}
		}
		return nodes;
	}
	
	@FXML
	void historyBack(ActionEvent event) throws SQLException {
		historyMove(true);
	}
	
	@FXML
	void historyFord(ActionEvent event) throws SQLException {
		historyMove(false);
	}
	
	void historyMove(Boolean back) throws SQLException {
		if(back) {
			if(history.size()>0&&indexHistory>0) {
				transitionPage(history.get(indexHistory),history.get(indexHistory-1),true);
				indexHistory--;
				diagrammeMAJ();
    			prochaineCompetitionMAJ();
			}
		}else {
			if(history.size()>0&&indexHistory<history.size()-1) {
				transitionPage(history.get(indexHistory),history.get(indexHistory+1),true);
				indexHistory++;
			}
		}
	}
	
	void removeFilter(Pane p, Node n) {
		if(annimEnded) {
			annimEnded=false;
			field=null;
			ArrayList<TranslateTransition> transitions=new ArrayList<TranslateTransition>();
			Boolean ok=false;
			for(Node e: p.getChildren()) {
				if(ok) {
					TranslateTransition t=new TranslateTransition(Duration.millis(250), e);
					t.setToY(e.getTranslateY()-35);
					transitions.add(t);
				}
				if(e.equals(n)) {
					ok=true;
				}
				if(!ok){field=e;}
			}
			p.setPrefHeight(p.getHeight()-35);
			for(TranslateTransition t: transitions) {
				t.play();
			}
			FadeTransition t=new FadeTransition(Duration.millis(250), n);
			t.setFromValue(1);
			t.setToValue(0);
			t.setOnFinished(e -> {
				p.getChildren().remove(n);
			});
			FadeTransition t2=new FadeTransition(Duration.millis(250), field);
			t2.setFromValue(1);
			t2.setToValue(0);
			t2.setOnFinished(e -> {
				p.getChildren().remove(field);
				annimEnded=true;
			});
			t.play();
			t2.play();
		}
	}
	
	void addFiltre(Pane p, Node n) {
		if(annimEnded) {
			annimEnded=false;
			int i=p.getChildren().indexOf(n);
			int lenListView=0;
			Boolean ok3=true;
			Boolean isListView=false;
			if(p.getChildren().get(i-1) instanceof ListView) {
				ListView l=(ListView)p.getChildren().get(i-1);
				lenListView=l.getItems().size();
				isListView=true;
			}
			ArrayList<TranslateTransition> transitions=new ArrayList<TranslateTransition>();
			Boolean ok=false;
			Boolean ok2=false;
			int nbrBtn=0;
			for(Node e: p.getChildren()) {
				if(ok) {
					TranslateTransition t=new TranslateTransition(Duration.millis(250), e);
					t.setToY(e.getTranslateY()+35);
					transitions.add(t);
					if(!Label.class.isInstance(e)&&!ok2) {
						if(e instanceof Button) {
							nbrBtn++;
						}
					}else {
						ok2=true;
					}
				}
				if(e.equals(n)) {
					ok=true;
				}
			}
			if(isListView&&nbrBtn+1>=lenListView) {
				ok3=false;
			}
			if(ok3) {
				p.setPrefHeight(p.getHeight()+35);
				for(TranslateTransition t: transitions) {
					t.play();
				}
				//new btn
				Button b=new Button("-");
				b.setFont(Font.font("Candara Light", 14));
				b.setPrefSize(30, 30);
				b.setTranslateX(152.5);
				b.setTranslateY(n.getLayoutY()+n.getTranslateY()+35);
				b.getStyleClass().add("section");
				b.getStyleClass().add("btnMenu");
				b.setOnMousePressed(e -> {
					elementPressed(e);
				});
				b.setOnMouseReleased(e -> {
					elementReleased(e);
				});
				b.setOnAction(e -> {
					removeFilter(p, b);
				});
				//new Field
				TextField f=new TextField();
				ListView l=new ListView();
				Boolean tf=true;
				if(p.getChildren().get(i-1) instanceof TextField) {
					if(p.getChildren().get(i-1).equals(personneFiltreDate)) {
						f.setPromptText("aaaa-mm-jj");
					}
					f.setFont(Font.font("Candara Light", 14));
					f.setPrefSize(125, 30);
					f.setTranslateX(187.5);
					f.setTranslateY(n.getLayoutY()+n.getTranslateY()+35);
					f.getStyleClass().add("fieldStyle-pan");
					f.getStyleClass().add("fieldStyle");
				}else {
					ListView li=(ListView)p.getChildren().get(i-1);
					l.setFixedCellSize(30);
					for(Object la: li.getItems()) {
						l.getItems().add(la);
					}
					l.setPrefSize(125, 30);
					l.setTranslateX(187.5);
					l.setTranslateY(n.getLayoutY()+n.getTranslateY()+35);
					l.getStyleClass().add("fieldStyle-pan");
					l.getStyleClass().add("fieldStyle");
					l.getStyleClass().add("sans-padding");
					//l.getSelectionModel().select(0);
					tf=false;
				}
				
				if(tf) {
					f.setId(p.getChildren().get(i-1).getId()+nbrBtn);
					p.getChildren().add(i+1, f);
				}else {
					l.setId(p.getChildren().get(i-1).getId()+nbrBtn);
					p.getChildren().add(i+1, l);
				}
				p.getChildren().add(i+2, b);
				
				FadeTransition t=new FadeTransition(Duration.millis(250), b);
				t.setFromValue(0);
				t.setToValue(1);
				FadeTransition t2;
				if(tf) {
					t2=new FadeTransition(Duration.millis(250), f);
				}else {
					t2=new FadeTransition(Duration.millis(250), l);
				}
				t2.setFromValue(0);
				t2.setToValue(1);
				t2.setOnFinished(e -> {
					annimEnded=true;
				});
				
				t.play();
				t2.play();
				
				updateUI();
			}else {
				annimEnded=true;
			}
		}
	}
	
	void setCategoriesBDD() throws SQLException {
		//Listes à mettre à jour
		ArrayList<ListView> listList=new ArrayList<ListView>();
		listList.add(personneFiltreSexe);
		listList.add(personneFiltreVille);
		listList.add(personneFiltreEquipe);
		listList.add(personneFiltreSport);
		listList.add(modificationCompetiteurSexeL);
		listList.add(modificationCompetiteurVilleL);
		listList.add(modificationCompetiteurSportL);
		listList.add(personneAjouterSexe);
		listList.add(personneAjouterVille);
		listList.add(personneAjouterSport);
		listList.add(equipeFiltreType);
		listList.add(equipeFiltreVille);
		listList.add(equipeFiltreSport);
		listList.add(equipeAjouterType);
		listList.add(equipeAjouterVille);
		listList.add(equipeAjouterSport);
		listList.add(modificationEquipeTypeL);
		listList.add(modificationEquipeVilleL);
		listList.add(modificationEquipeSportL);
		listList.add(equipeModificationFiltreVille);
		listList.add(equipeModificationFiltreSexe);
		listList.add(competitionAjouterType);
		listList.add(competitionAjouterVille);
		listList.add(competitionAjouterSport);
		listList.add(competitionFiltreType);
		listList.add(competitionFiltreVille);
		listList.add(competitionFiltreSport);
		
		listList.add(modificationCompetitionTypeL);
		listList.add(modificationCompetitionVilleL);
		listList.add(modificationCompetitionSportL);
		listList.add(competitionModificationFiltreVille);
		listList.add(competitionModificationFiltreType);
		
		for(ListView l: listList) {
			l.getItems().clear();
			l.setFixedCellSize(30);
			l.setClip(new Rectangle(125, 30));
		}
		
		//Remove field created
		ArrayList<Pane> paneFieldCreated=new ArrayList<Pane>();
		paneFieldCreated.add(personneFiltreContenu);
		paneFieldCreated.add(equipeFiltreContenu);
		paneFieldCreated.add(equipeModificationFiltreContenu);
		for(Pane p:paneFieldCreated) {
			int nbrField=0;
			for(int n=0;n<p.getChildren().size();n++) {
				if(p.getChildren().get(n) instanceof Button) {
					if(((Button)p.getChildren().get(n)).getText().equals("-")) {
						int index=p.getChildren().indexOf(p.getChildren().get(n));
						p.getChildren().remove(index);
						p.getChildren().remove(index-1);
						n--;n--;
						nbrField++;
					}
				}
			}
			if(nbrField!=0) {
				for(Node n:p.getChildren()) {
					n.setTranslateY(0);
				}
				p.setPrefHeight(p.getHeight()-35*nbrField);
			}
		}
		
		//Le label de texte
		Label s=new Label();
		s.setFont(Font.font("Candara Light"));
		s.setMinHeight(30);
		
		//Categories
		Map<String, ArrayList<String>> data=bdd.getCategories();
		
		if(data.size()!=0) {
			//liste sexe
			for(String sexe: data.get("competiteur_sexe")) {
				s.setText("   "+sexe);
				personneFiltreSexe.getItems().add(s.getText());
				modificationCompetiteurSexeL.getItems().add(s.getText());
				personneAjouterSexe.getItems().add(s.getText());
				equipeModificationFiltreSexe.getItems().add(s.getText());
			}
			
			//liste ville
			for(String ville: data.get("ville_nom")) {
				s.setText("   "+ville);
				personneFiltreVille.getItems().add(s.getText());
				modificationCompetiteurVilleL.getItems().add(s.getText());
				personneAjouterVille.getItems().add(s.getText());
				equipeFiltreVille.getItems().add(s.getText());
				equipeAjouterVille.getItems().add(s.getText());
				modificationEquipeVilleL.getItems().add(s.getText());
				equipeModificationFiltreVille.getItems().add(s.getText());
				competitionAjouterVille.getItems().add(s.getText());
				competitionFiltreVille.getItems().add(s.getText());
				modificationCompetitionVilleL.getItems().add(s.getText());
				competitionModificationFiltreVille.getItems().add(s.getText());
			}
			
			//liste equipe
			for(String equipe: data.get("equipe_nom")) {
				s.setText("   "+equipe);
				personneFiltreEquipe.getItems().add(s.getText());
			}
			
			//liste sport
			for(String sport: data.get("sport_nom")) {
				s.setText("   "+sport);
				personneFiltreSport.getItems().add(s.getText());
				modificationCompetiteurSportL.getItems().add(s.getText());
				personneAjouterSport.getItems().add(s.getText());
				equipeFiltreSport.getItems().add(s.getText());
				equipeAjouterSport.getItems().add(s.getText());
				modificationEquipeSportL.getItems().add(s.getText());
				competitionAjouterSport.getItems().add(s.getText());
				competitionFiltreSport.getItems().add(s.getText());
				modificationCompetitionSportL.getItems().add(s.getText());
			}
			
			//liste type
			for(String type: data.get("equipe_type")) {
				s.setText("   "+type);
				equipeFiltreType.getItems().add(s.getText());
				equipeAjouterType.getItems().add(s.getText());
				modificationEquipeTypeL.getItems().add(s.getText());
				competitionAjouterType.getItems().add(s.getText());
				competitionFiltreType.getItems().add(s.getText());
				modificationCompetitionTypeL.getItems().add(s.getText());
				competitionModificationFiltreType.getItems().add(s.getText());
			}
		}
		
		//Reinitialisation listes
		for(ListView l:listList) {
			l.scrollTo(0);
		}
	}
	
	ArrayList<ArrayList<String>> getFilters(Pane p){
		ArrayList<ArrayList<String>> filters=new ArrayList<ArrayList<String>>();
		String id=" ";
		ArrayList<String> field=null;
		for(Node n: p.getChildren()) {
			if(n instanceof TextField||n instanceof ListView) {
				if(!n.getId().contains(id)) {
					if(field!=null&&field.size()>1) {
						filters.add(field);
					}
					id=n.getId();
					field=new ArrayList<String>();
					field.add(id);
				}
				String s;
				if(n instanceof TextField) {
					s=((TextField)n).getText();
				}else {
					if(((ListView) n).getSelectionModel().getSelectedItem()!=null) {
						s=((ListView) n).getSelectionModel().getSelectedItem().toString().substring(3);
					}else {
						s="";
					}
				}
				if(!s.equals("")) {
					field.add(s);
				}
				if(p.getChildren().indexOf(n)+1==p.getChildren().size()-1&&field.size()>1) {
					filters.add(field);
				}
			}
		}
		return(filters);
	}
	
	ObservableList getObservableList(ArrayList data) {
		ObservableList out=FXCollections.observableArrayList();
		for(Object l: data) {
			out.add(l);
		}
		return(out);
	}
	
	@FXML
	void unselectedListView(KeyEvent event) {
		ListView l=(ListView)event.getSource();
		if(event.getCode()==KeyCode.DELETE) {
			l.getSelectionModel().clearSelection();
		}
	}
	
	@FXML
	void tableViewDisplaySelection(MouseEvent event) throws SQLException {
		TableView t=(TableView)event.getSource();
		Object o=t.getSelectionModel().getSelectedItem();
		if(o instanceof Cellule) {
			history.clear();
			indexHistory=2;
			history.add(mainUI);
			Pane p=null;
			if(t.equals(personneDisplayResultT)) {
				showCompetiteur(((Cellule)o).getId());
				transitionPage(personne,modificationCompetiteur,true);
				history.add(personne);
				history.add(modificationCompetiteur);
				p=modificationCompetiteurContenu;
			}else if(t.equals(equipeDisplayResultT)) {
				showEquipe(((Cellule)o).getId());
				transitionPage(equipe,modificationEquipe,true);
				history.add(equipe);
				history.add(modificationEquipe);
				p=modificationEquipeContenu;
				if(!toogleModificationEquipe) {
					modificationEquipeGoToOtherPart(new ActionEvent());
				}
			}else if(t.equals(competitionDisplayResultT)||t.equals(equipeModificationHistoriqueResultatsTable)) {
				showCompetition(((Cellule)o).getId());
				if(t.equals(competitionDisplayResultT)) {
					if(competition.isVisible()) {
						transitionPage(competition,modificationCompetition,true);
						history.add(competition);
					}else {
						transitionPage(mainUI,modificationCompetition,true);
					}
				}else {
					transitionPage(equipeModificationHistoriquePage,modificationCompetition,true);
					history.add(equipe);
					history.add(modificationEquipe);
					history.add(equipeModificationHistoriquePage);
					indexHistory++;
				}
				history.add(modificationCompetition);
				p=modificationCompetitionContenu;
				if(!toogleModificationCompetition) {
					modificationCompetitionGoToOtherPart(new ActionEvent());
				}
			}
			if(p!=null) {
				for(Node n:p.getChildren()) {
					if(n instanceof ListView) {
						((ListView) n).getSelectionModel().clearSelection();
					}
				}
				modifyTextField.clear();
			}
		}
	}
	
	@FXML
	void changeTextFieldValueFromListView(MouseEvent event) {
		ListView l=(ListView)event.getSource();
		String value=l.getSelectionModel().getSelectedItem().toString().substring(3);
		Pane p=(Pane)l.getParent();
		int i=p.getChildren().indexOf(l);
		TextField t=(TextField)p.getChildren().get(i-1);
		t.setText(value);
		if(!modifyTextField.contains(t)) {
			modifyTextField.add(t);
		}
	}
	
	@FXML
	void unselectedListViewFromKeyOnTextField(KeyEvent event) {
		TextField t=(TextField)event.getSource();
		if(!modifyTextField.contains(t)) {
			modifyTextField.add(t);
		}
		Pane p=(Pane)t.getParent();
		int i=p.getChildren().indexOf(t);
		ListView l=(ListView)p.getChildren().get(i+1);
		l.getSelectionModel().clearSelection();
	}
	
	@FXML
	void textFieldModified(KeyEvent event) {
		TextField t=(TextField)event.getSource();
		if(!modifyTextField.contains(t)) {
			modifyTextField.add(t);
		}
	}
	
	void addSupprimerBtn(Boolean toogleBtn, String table) throws SQLException {
		if(indexElementAdded!=0&&toogleBtn) {
			bdd.remove(table, indexElementAdded, 0);
			actionConfirmed();
			setCategoriesBDD();
			if(table.equals("competiteur")){
				personneAddNouvelle(new ActionEvent());
			}else if(table.equals("equipe")) {
				equipeAddNouvelle(new ActionEvent());
			}
		}else {
			actionRefused();
		}
	}
	
	void modificationBtn(int id, String table) throws SQLException {
		String data="";
		if(modifyTextField.size()>0) {
			for(TextField t:modifyTextField) {
				if(t.getId().equals("id_ville")) {
					if(!t.getText().equals("")) {
						if(!bdd.exists("nom='"+t.getText()+"'", "ville")) {
							bdd.add("('"+t.getText()+"')", "ville");
						}
						data+=table+".id_ville=(select id_ville from ville where nom='"+t.getText()+"')";
					}else {
						data+=table+".id_ville=0";
					}
				}else if(t.getId().equals("id_sport")) {
					if(!t.getText().equals("")) {
						if(!bdd.exists("libelle='"+t.getText()+"'", "sport")) {
							bdd.add("('"+t.getText()+"')", "sport");
						}
						data+=table+".id_sport=(select id_sport from sport where libelle='"+t.getText()+"')";
					}else {
						data+=table+".id_sport=0";
					}
				}else {
					data+=table+"."+t.getId()+"='"+t.getText()+"'";
				}
				if(!t.equals(modifyTextField.get(modifyTextField.size()-1))) {
					data+=", ";
				}
			}
			bdd.update(data, table, id, 0);
			setCategoriesBDD();
			modifyTextField.clear();
		}
		actionConfirmed();
	}
	
	void modifySupprimerBtn(int id, String table, Pane mp, Pane p) throws SQLException {
		bdd.remove(table, id, 0);
		if(p.equals(personne)) {
			personneGoToRechercher(new ActionEvent());
		}else if(p.equals(equipe)) {
			equipeGoToRechercher(new ActionEvent());
		}else if(p.equals(competition)) {
			competitionGoToRechercher(new ActionEvent());
		}
		transitionPage(mp,p,true);
		history.clear();
		indexHistory=1;
		history.add(mainUI);
		history.add(p);
		actionConfirmed();
		setCategoriesBDD();
	}
	
	void actionConfirmed() {
		actionValidation.setTranslateX(60);
		actionValidedRefusedAnnim();
	}
	
	void actionRefused() {
		actionValidation.setTranslateX(-60);
		actionValidedRefusedAnnim();
	}
	
	void actionValidedRefusedAnnim() {
		if(actionConfirmedRefusedAnnimFinished) {
			actionConfirmedRefusedAnnimFinished=false;
			FadeTransition tf=new FadeTransition(Duration.millis(200), actionValidation);
			tf.setFromValue(0);
			tf.setToValue(1);
			tf.setOnFinished(e -> {
				FadeTransition tf2=new FadeTransition(Duration.millis(600), actionValidation);
				tf2.setFromValue(1);
				tf2.setToValue(1);
				tf2.setOnFinished(e1 -> {
					FadeTransition tf3=new FadeTransition(Duration.millis(200), actionValidation);
					tf3.setFromValue(1);
					tf3.setToValue(0);
					tf3.setOnFinished(e2 -> {
						actionValidation.setTranslateX(0);
						actionConfirmedRefusedAnnimFinished=true;
					});
					tf3.play();
				});
				tf2.play();
			});
			tf.play();
		}
	}
	
	void lancerRecherche(Pane p, Pane pg, Pane pd, Button ab, Button rb, Pane fp, TableView t,String table) throws SQLException {
		moveDisplay(pg,0.0,0.0,ab,rb);
		moveDisplay(pd,0.0,0.0,ab,rb);
		if(ab.equals(actuelEquipe)) {
			actuelEquipe=rb;
		}else if(ab.equals(actuelPersonne)) {
			actuelPersonne=rb;
		}else if(ab.equals(actuelCompetition)) {
			actuelCompetition=rb;
		}
		ArrayList<ArrayList<String>> filters=getFilters(fp);
		ArrayList<Cellule> data=bdd.searchToTableView(table, filters);
		t.setItems(getObservableList(data));
		if(history.size()>2) {
			history.clear();
			indexHistory=1;
			history.add(mainUI);
			history.add(p);
		}
	}
	
	ArrayList lancerAjout(Pane p, Pane pc, Boolean toogleBtn, Button ab, Button ba, Pane pg, Pane pd) throws SQLException {
		ArrayList out=new ArrayList();
		if(ab.equals(ba)) {
			if(toogleBtn!=true) {
				Map<String, String> data=new Hashtable<String, String>();
				for(Node n: pc.getChildren()) {
					if(n instanceof TextField) {
						data.put(n.getId(), ((TextField)n).getText());
					}
				}
				Boolean ok=true;
				for(Map.Entry<String, String> line: data.entrySet()) {
					if(line.getValue().equals("")) {
						out.add(false);
						actionRefused();
						ok=false;
					}
				}
				if(ok) {
					out.add(true);
					out.add(data);
				}
			}else {
				out.add(false);
				actionRefused();
			}
		}else {
			moveDisplay(pg,-362.5,0.0,ab,ba);
			moveDisplay(pd,0.0,-475.0,ab,ba);
			if(p.equals(personne)) {
				personneAddNouvelle(new ActionEvent());
			}else if(p.equals(equipe)) {
				equipeAddNouvelle(new ActionEvent());
			}else if(p.equals(competition)) {
				competitionAddNouvelle(new ActionEvent());
			}
			out.add(false);
		}
		if(ab.equals(actuelEquipe)) {
			actuelEquipe=ba;
		}else if(ab.equals(actuelPersonne)) {
			actuelPersonne=ba;
		}else if(ab.equals(actuelCompetition)) {
			actuelCompetition=ba;
		}
		if(history.size()>2) {
			history.clear();
			indexHistory=1;
			history.add(mainUI);
			history.add(p);
		}
		modifyTextField.clear();
		return out;
	}
	
	void addNouvelleBtn(Boolean toogleB, Pane p) {
		if(toogleB.equals(toogleAddEquipe)) {
			toogleAddEquipe=false;
		}else if(toogleB.equals(toogleAddPersonne)) {
			toogleAddPersonne=false;
		}else if(toogleB.equals(toogleAddCompetition)) {
			toogleAddCompetition=false;
		}
		for(Node n: p.getChildren()) {
			if(n instanceof TextField) {
				((TextField) n).setText("");
			}else if(n instanceof ListView) {
				((ListView) n).getSelectionModel().clearSelection();
				((ListView) n).scrollTo(0);
			}
		}
		indexElementAdded=0;
		modifyTextField.clear();
	}
	
	void goToOtherPartBtn(Button btn, Pane p1, Pane p2, Boolean toogleBtn, TableView<Cellule> t, Label ls, ListView ts, Button bs, String msg1, String msg2) throws SQLException {
		TranslateTransition tt=new TranslateTransition(Duration.millis(500), p1);
		TranslateTransition tt2=new TranslateTransition(Duration.millis(500), p2);
		FadeTransition tf=new FadeTransition(Duration.millis(250), btn);
		tf.setFromValue(1);
		tf.setToValue(0);
		if(toogleBtn) {
			String table="";
			if(btn.equals(modificationEquipeC)) {
				toogleModificationEquipe=false;
				table="equipe";
			}else if(btn.equals(modificationCompetitionE)) {
				toogleModificationCompetition=false;
				table="competition";
			}
			Object o=t.getSelectionModel().getSelectedItem();
			int id=((Cellule)o).getId();
			if(bdd.isMixte(id, table)) {
				ls.setVisible(true);
				ts.setVisible(true);
				bs.setVisible(true);
			}else {
				ls.setVisible(false);
				ts.setVisible(false);
				bs.setVisible(false);
			}
			setCategoriesBDD();
			if(table.equals("equipe")) {
				modificationMAJ(equipeDisplayResultT,equipeModificationFiltreContenu,"id_equipe ","0","equipe","sexe","competiteur",equipeModificationDisplayResultTBottom,equipeModificationDisplayResultTTop,"equipe.competiteur");
			}else if(table.equals("competition")) {
				modificationMAJ(competitionDisplayResultT,competitionModificationFiltreContenu,"id_equipe","(select inscription_equipe.id_equipe from inscription_equipe where inscription_equipe.id_competition="+id+" union select inscription_equipe.id_equipe from inscription_equipe, competition where competition.id_competition=inscription_equipe.id_competition and competition.date_debut >= (select date_debut from competition where id_competition="+id+") and competition.date_fin <= (select date_fin from competition where id_competition="+id+"))","competition","type","equipe",competitionModificationDisplayResultTBottom,competitionModificationDisplayResultTTop,"competition.equipe");
			}
			tt.setToY(-400);
			tt2.setToX(-467.6);
			tf.setOnFinished(e -> {
				btn.setText(msg1);
				FadeTransition tf2=new FadeTransition(Duration.millis(250), btn);
				tf2.setFromValue(0);
				tf2.setToValue(1);
				tf2.play();
			});
		}else {
			if(btn.equals(modificationEquipeC)) {
				toogleModificationEquipe=true;
			}else if(btn.equals(modificationCompetitionE)) {
				toogleModificationCompetition=true;
			}
			tt.setToY(0);
			tt2.setToX(0);
			tf.setOnFinished(e -> {
				btn.setText(msg2);
				FadeTransition tf2=new FadeTransition(Duration.millis(250), btn);
				tf2.setFromValue(0);
				tf2.setToValue(1);
				tf2.play();
			});
		}
		tt.play();
		tt2.play();
		tf.play();
	}
	
	void modificationMAJ(TableView<Cellule> t, Pane p, String champ1, String champ2, String table, String champ3, String table2, TableView t2, TableView t3, String table3) throws SQLException {
		Object o=t.getSelectionModel().getSelectedItem();
		int id=((Cellule)o).getId();
		
		ArrayList<ArrayList<String>> filters=getFilters(p);
		ArrayList<String> f1=new ArrayList<String>();
		f1.add(champ1);
		f1.add(champ2);
		filters.add(f1);
		ArrayList<String> f2=new ArrayList<String>();
		f2.add("id_sport");
		f2.add(bdd.getSport(id,table));
		filters.add(f2);
		if(!bdd.isMixte(id, table)) {
			ArrayList<String> type=new ArrayList<String>();
			type.add(champ3);
			type.add(bdd.getType(id, table));
			filters.add(type);
		}
		ArrayList<Cellule> data=bdd.searchToTableView(table2, filters);
		t2.setItems(getObservableList(data));
		
		ArrayList<ArrayList<String>> filters2=new ArrayList<ArrayList<String>>();
		ArrayList<String> f3=new ArrayList<String>();
		f3.add(String.valueOf(id));
		filters2.add(f3);
		ArrayList<Cellule> data2=bdd.searchToTableView(table3, filters2);
		t3.setItems(getObservableList(data2));
	}
	
	@FXML
	void unselectedTableView(MouseEvent event) {
		TableView t=(TableView)event.getSource();
		if(t.equals(equipeModificationDisplayResultTTop)||t.equals(equipeModificationDisplayResultTBottom)) {
			if(t.equals(equipeModificationDisplayResultTTop)) {
				equipeModificationDisplayResultTBottom.getSelectionModel().clearSelection();
			}else {
				equipeModificationDisplayResultTTop.getSelectionModel().clearSelection();
			}
		}else {
			if(t.equals(competitionModificationDisplayResultTTop)) {
				competitionModificationDisplayResultTBottom.getSelectionModel().clearSelection();
			}else {
				competitionModificationDisplayResultTTop.getSelectionModel().clearSelection();
			}
		}
	}
	
	void prefFileMAJ() {
		
		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			Writer wr = new FileWriter(currentDirectory.getCanonicalPath()+"\\src\\fr\\M2L\\Ressources\\SCPrefs");
			String data="Sombre:";
			if(sombre) {
				data+="True\n";
			}else {
				data+="False\n";
			}
			data+="IP:"+mysqlServeurIP.getText()+"\n";
			data+="Port:"+mysqlServeurPort.getText()+"\n";
			data+="Nom:"+baseNom.getText()+"\n";
			data+="Rdeco:"+shortcuts.get(0)[0]+";"+shortcuts.get(0)[1]+"\n";
			data+="Rback:"+shortcuts.get(1)[0]+";"+shortcuts.get(1)[1]+"\n";
			data+="Rforward:"+shortcuts.get(2)[0]+";"+shortcuts.get(2)[1];
			wr.write(data);
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	void loadPrefFile() {
		try
        {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			File file = new File(currentDirectory.getCanonicalPath()+"\\src\\fr\\M2L\\Ressources\\SCPrefs");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String [] line = scanner.nextLine().split(":");
                if(line[0].equals("Sombre")) {
                	if(line[1].equals("True")) {
                		sombre=true;
                		root.getStylesheets().add(this.getClass().getResource("Ressources\\CSS\\DarkStyle.css").toExternalForm());
                	}else if(line[1].equals("False")){
                		sombre=false;
                	}
                }else if(line[0].equals("IP")) {
                	mysqlServeurIP.setText(line[1]);
                }else if(line[0].equals("Port")) {
                	mysqlServeurPort.setText(line[1]);
                }else if(line[0].equals("Nom")) {
                	baseNom.setText(line[1]);
                }else if(line[0].equals("Rdeco")) {
                	String [] line2=line[1].split(";");
                	shortcuts.add(new String[]{line2[0],line2[1],"deconnection"});
                }else if(line[0].equals("Rback")) {
                	String [] line2=line[1].split(";");
                	shortcuts.add(new String[]{line2[0],line2[1],"page_precedente"});
                }else if(line[0].equals("Rforward")) {
                	String [] line2=line[1].split(";");
                	shortcuts.add(new String[]{line2[0],line2[1],"page_suivante"});
                }
            }
            updateUI();
            refreshShortcuts();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	}
}
