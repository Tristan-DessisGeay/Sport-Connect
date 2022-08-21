package fr.M2L_Add;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class Acces_BDD {
	
	private java.sql.Connection cn = null;
	private java.sql.Statement st = null;
	private java.sql.ResultSet rs = null;
	
	public Acces_BDD(String ip, String port, String base) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.cn = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+base,"root","");
			this.st = this.cn.createStatement();
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e1) {
			
		}
	}
	
	public Boolean connexion(String login, String password, int id) throws SQLException {
		if(st!=null) {
			String request="select if((select id_employe from employe where identifiant='"+login+"' and mot_de_passe='"+password+"')="+id+",1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
		}
		return false;
	}
	
	public ArrayList<Cellule> getEmploye() throws SQLException{
		ArrayList<Cellule> out=new ArrayList<Cellule>();
		if(st!=null) {
			String request="select identifiant, date_creation, id_employe from employe;";
			rs = st.executeQuery(request);
			while(rs.next()) {
				out.add(new Cellule(rs.getString("identifiant"),rs.getString("date_creation"),rs.getInt("id_employe")));
			}
		}
		return out;
	}
	
	public void delete(int id) throws SQLException {
		if(st!=null) {
			String request="delete from employe where id_employe="+id+";";
			st.execute(request);
		}
	}
	
	public void add(String identifiant,String mdp) throws SQLException {
		if(st!=null) {
			String request="insert into employe(identifiant,mot_de_passe,date_creation) values ('"+identifiant+"','"+mdp+"',now());";
			st.execute(request);
		}
	}
	
	public void modifier(String identifiant, String mdp, int id) throws SQLException {
		if(st!=null) {
			String request="update employe set identifiant='"+identifiant+"', mot_de_passe='"+mdp+"' where id_employe="+id+";";
			st.execute(request);
		}
	}
	
	public Boolean exist(String identifiant, int id) throws SQLException {
		if(st!=null) {
			String request="select if((select identifiant from employe where identifiant='"+identifiant+"'";
			if(id!=0) {
				request+=" and id_employe<>"+id;
			}
			request+=")='"+identifiant+"',1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
			return false;
		}
		return true;
	}
	
	public Boolean checkMdp(String mdp, int id) throws SQLException {
		if(st!=null) {
			String request="select if((select id_employe from employe where mot_de_passe='"+mdp+"' and id_employe="+id+")="+id+",1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
		}
		return false;
	}

}