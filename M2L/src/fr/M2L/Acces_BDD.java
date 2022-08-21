package fr.M2L;

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
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+base,"root","");
			this.st = this.cn.createStatement();
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e1) {
			
		}
		
		
	}

	public void add(String data, String table) throws SQLException {
		if(st!=null) {
			String request="insert into "+table+"(";
			if(table.equals("ville")) {
				request+="nom) values ";
			}else if(table.equals("competiteur")) {
				request+="prenom,nom,sexe,date_naissance,email,id_ville,id_sport) values ";
			}else if(table.equals("sport")) {
				request+="libelle) values ";
			}else if(table.equals("equipe")) {
				request+="nom,type,id_ville,id_sport) values ";
			}else if(table.equals("competition")) {
				request+="libelle,type,date_debut,date_fin,id_ville,id_sport) values ";
			}else if(table.equals("inscription_equipe")) {
				request+="id_competition,id_equipe,date) values ";
			}
			request+=data+";";
			st.execute(request);
		}
	}
	
	public Boolean connexion(String login, String password) throws SQLException {
		if(st!=null) {
			String request="select if((select identifiant from employe where identifiant='"+login+"' and mot_de_passe='"+password+"')='"+login+"',1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
		}
		return false;
	}
	
	public Boolean exists(String data, String table) throws SQLException {
		if(st!=null) {
			String request="select distinct count(*) as ok from "+table+" where "+data+";";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
		}
		return false;
	}
	
	public int getMaxId(String table, String id) throws SQLException {
		if(st!=null) {
			String request="select max("+id+") as id from "+table+";";
			rs=st.executeQuery(request);
			while(rs.next()) {
				return rs.getInt("id");
			}
		}
		return 0;
	}
	
	public ObservableList<PieChart.Data> getDiagrammeData(String data) throws SQLException{
		ObservableList<PieChart.Data> out=FXCollections.observableArrayList();
		if(st!=null) {
			String request="";
			if(data.equals("equipeType")) {
				request="select type as str, count(type) as nbr from equipe group by str;";
			}else if(data.equals("sportPratique")) {
				request="select sport.libelle as str, count(competiteur.id_sport) as nbr from competiteur, sport where competiteur.id_sport=sport.id_sport group by str;";
			}
			rs=st.executeQuery(request);
			while(rs.next()) {
				out.add(new PieChart.Data(rs.getString("str"), rs.getInt("nbr")));
			}
		}
		return out;
	}
	
	public ArrayList prochaineCompetition() throws SQLException {
		ArrayList out=new ArrayList();
		out.add("Aucune compétition à venir");
		out.add("");
		out.add(0);
		if(st!=null) {
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			String request="select competition.libelle, ville.nom, competition.id_competition from competition, ville where competition.id_ville=ville.id_ville and date_debut>='"+formatter.format(date)+"' order by datediff(date_debut,'"+formatter.format(date)+"') limit 1;";
			rs=st.executeQuery(request);
			while(rs.next()) {
				out.set(0, rs.getString("libelle"));
				out.set(1, rs.getString("nom"));
				out.set(2, rs.getInt("id_competition"));
			}
		}
		return out;
	}
	
	public void remove(String table, int id, int id2) throws SQLException {
		if(st!=null) {
			String request="";
			if(table.equals("inscription_equipe")){
				request = "delete from inscription_equipe where id_competition="+id+" and id_equipe="+id2+";";
			}else if(table.equals("reset.inscription")) {
				request="delete from inscription_equipe where id_competition="+id+";";
			}
			else{
				request = "delete from "+table+" where id_"+table+"="+id+";";
			}
			st.executeUpdate(request);
		}
	}
	
	public void update(String data, String table, int id, int id2) throws SQLException {
		if(st!=null) {
			String request="update ";
			if(!data.equals("")){
				request+=table+" set ";
				if(table.equals("inscription_equipe")){
					request+=data+" where id_competition="+id+" and id_equipe="+id2+";";
				}else if(table.equals("reset.equipe")) {
					request="update competiteur set id_equipe=0 where id_equipe="+id+";";
				}else{
					request+=data+" where id_"+table+"="+id+";";
				}
				st.execute(request);
			}
		}
	}
	
	public Boolean isMixte(int id, String table) throws SQLException {
		if(st!=null) {
			String request="select if((select type from "+table+" where id_"+table+"="+id+")='Mixte',1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
		}
		return false;
	}
	
	public ArrayList searchFromId(String table, int id, int id2) throws SQLException {
		ArrayList out=new ArrayList();
		if(st!=null) {
			String request="";
			int id_equipe=0;
			if(table.equals("inscription_equipe")) {
				request = "select date from inscription_equipe where id_competition="+id+" and id_equipe="+id2+";";
			}else if(table.equals("competiteur")) {
				request="select id_equipe from competiteur where id_competiteur="+id;
				rs=st.executeQuery(request);
				while(rs.next()) {
					id_equipe=rs.getInt("id_equipe");
				}
				if(id_equipe!=0) {
					request="select competiteur.prenom, competiteur.nom, competiteur.sexe, competiteur.email, competiteur.date_naissance, ville.nom as ville_nom, equipe.nom as equipe_nom, sport.libelle as sport_libelle from competiteur, ville, equipe, sport where sport.id_sport=competiteur.id_sport and competiteur.id_ville=ville.id_ville and competiteur.id_equipe=equipe.id_equipe and competiteur.id_competiteur="+id+";";
				}else {
					request="select competiteur.prenom, competiteur.nom, competiteur.sexe, competiteur.email, competiteur.date_naissance, ville.nom as ville_nom, sport.libelle as sport_libelle from competiteur, ville, sport where sport.id_sport=competiteur.id_sport and competiteur.id_ville=ville.id_ville and competiteur.id_competiteur="+id+";";
				}
			}else if(table.equals("equipe")) {
				request="select equipe.nom, equipe.type, ville.nom as ville_nom, sport.libelle as sport_libelle from equipe, ville, sport where equipe.id_ville=ville.id_ville and equipe.id_sport=sport.id_sport and equipe.id_equipe="+id+";";
			}else if(table.equals("competition")) {
				request+="select competition.libelle, competition.type, ville.nom as ville_nom, sport.libelle as sport_libelle, competition.date_debut, competition.date_fin from competition, ville, sport where competition.id_ville=ville.id_ville and competition.id_sport=sport.id_sport and competition.id_competition="+id+";";
			}
			rs=st.executeQuery(request);
			while(rs.next()) {
				if(table.equals("competiteur")) {
					out.add(rs.getString("prenom"));
					out.add(rs.getString("nom"));
					out.add(rs.getString("sexe"));
					out.add(rs.getString("email"));
					out.add(rs.getString("date_naissance"));
					out.add(rs.getString("ville_nom"));
					out.add(rs.getString("sport_libelle"));
					if(id_equipe!=0) {
						out.add(rs.getString("equipe_nom"));
					}else {
						out.add("→ Equipes");
					}
				}else if(table.equals("equipe")) {
					out.add(rs.getString("nom"));
					out.add(rs.getString("type"));
					out.add(rs.getString("ville_nom"));
					out.add(rs.getString("sport_libelle"));
				}else if(table.equals("competition")) {
					out.add(rs.getString("libelle"));
					out.add(rs.getString("type"));
					out.add(rs.getString("ville_nom"));
					out.add(rs.getString("sport_libelle"));
					out.add(rs.getString("date_debut"));
					out.add(rs.getString("date_fin"));
				}
			}
		}
		return(out);
	}
	
	public int getEquipeId(int id) throws SQLException{
		int id_equipe=0;
		if(st!=null) {
			String request="select id_equipe from competiteur where id_competiteur="+id+";";
			rs=st.executeQuery(request);
			while(rs.next()) {id_equipe=rs.getInt("id_equipe");}
		}
		return id_equipe;
	}
	
	public int getEmployeId(String login) throws SQLException {
		int employe_id=0;
		if(st!=null) {
			String request="select id_employe from employe where login='"+login+"';";
			rs=st.executeQuery(request);
			while(rs.next()) {employe_id=rs.getInt("id_employe");}
		}
		return employe_id;
	}
	
	public String getType(int id, String table) throws SQLException {
		String out="";
		if(st!=null) {
			String request="select type from "+table+" where id_"+table+"="+id+";";
			rs=st.executeQuery(request);
			while(rs.next()) {out=rs.getString("type");}
		}
		return out;
	}
	
	public String getSport(int id, String table) throws SQLException {
		String out="";
		if(st!=null) {
			String request="select sport.libelle as sport_libelle from "+table+", sport where sport.id_sport="+table+".id_sport and "+table+".id_"+table+"="+id+";";
			rs=st.executeQuery(request);
			while(rs.next()) {out=rs.getString("sport_libelle");}
		}
		return out;
	}
	
	public ArrayList searchToTableView(String tableView, ArrayList<ArrayList<String>> filters) throws SQLException{
		ArrayList out = new ArrayList();
		if(st!=null) {
			String request="select distinct ", requestTmp="";
			Boolean first=true;
			if(tableView.equals("competiteur")) {
				request+="competiteur.prenom, competiteur.nom, competiteur.id_competiteur from competiteur ";
				if(filters.size()!=0) {
					requestTmp+="where ";
				}
				for(ArrayList<String> filter: filters) {
					if(!first) {
						requestTmp+="and ";
					}else {
						first=false;
					}
					String attrib=filter.get(0);
					if(attrib.equals("id_ville")) {
						request+=", ville ";
						requestTmp+="ville.id_ville=competiteur.id_ville and ";
					}else if(attrib.equals("id_equipe")) {
						request+=", equipe ";
						requestTmp+="equipe.id_equipe=competiteur.id_equipe and ";
					}else if(attrib.equals("id_sport")) {
						request+=", sport ";
						requestTmp+="sport.id_sport=competiteur.id_sport and ";
					}
					requestTmp+="(";
					for(int f=1;f<filter.size();f++) {
						if(attrib.equals("id_ville")) {
							requestTmp+="ville.nom='"+filter.get(f)+"'";
						}else if(attrib.equals("id_equipe")) {
							requestTmp+="equipe.nom='"+filter.get(f)+"'";
						}else if(attrib.equals("id_sport")) {
							requestTmp+="sport.libelle='"+filter.get(f)+"'";
						}else {
							requestTmp+="competiteur."+attrib+"='"+filter.get(f)+"'";
						}
						if(f!=filter.size()-1) {
							requestTmp+=" or ";
						}else {
							requestTmp+=") ";
						}
					}
				}
				request+=requestTmp;
				request+="order by competiteur.prenom;";
			}else if(tableView.equals("equipe")) {
				request+="equipe.nom as e_nom, ville.nom as v_nom, equipe.id_equipe as e_id from equipe, ville ";
				requestTmp+="where ville.id_ville=equipe.id_ville ";
				if(filters.size()!=0) {
					requestTmp+="and ";
				}
				for(ArrayList<String> filter: filters) {
					if(!first) {
						requestTmp+="and ";
					}else {
						first=false;
					}
					String attrib=filter.get(0);
					if(attrib.equals("id_sport")) {
						request+=", sport ";
						requestTmp+="sport.id_sport=equipe.id_sport and ";
					}
					requestTmp+="(";
					for(int f=1;f<filter.size();f++) {
						if(attrib.equals("id_ville")) {
							requestTmp+="ville.nom='"+filter.get(f)+"'";
						}else if(attrib.equals("id_sport")) {
							requestTmp+="sport.libelle='"+filter.get(f)+"'";
						}else if(attrib.equals("id_equipe")) {
							requestTmp+="equipe.id_equipe not in "+filter.get(f);
						}
						else {
							requestTmp+="equipe."+attrib+"='"+filter.get(f)+"'";
						}
						if(f!=filter.size()-1) {
							requestTmp+=" or ";
						}else {
							requestTmp+=") ";
						}
					}
				}
				request+=requestTmp;
				request+="order by equipe.nom;";
			}else if(tableView.equals("equipe.competiteur")) {
				String id=filters.get(0).get(0);
				request+="competiteur.prenom, competiteur.nom, competiteur.id_competiteur from competiteur, equipe where equipe.id_equipe=competiteur.id_equipe and equipe.id_equipe="+id+" order by competiteur.prenom;";
				tableView="competiteur";
			}else if(tableView.equals("competition")) {
				request+="competition.libelle as c_libelle, competition.type as c_type, competition.id_competition as c_id from competition ";
				if(filters.size()!=0) {
					requestTmp+="where ";
				}
				for(ArrayList<String> filter: filters) {
					if(!first) {
						requestTmp+="and ";
					}else {
						first=false;
					}
					String attrib=filter.get(0);
					if(attrib.equals("id_sport")) {
						request+=", sport ";
						requestTmp+="sport.id_sport=competition.id_sport and ";
					}else if(attrib.equals("id_ville")) {
						request+=", ville ";
						requestTmp+="ville.id_ville=competition.id_ville and ";
					}
					requestTmp+="(";
					for(int f=1;f<filter.size();f++) {
						if(attrib.equals("id_ville")) {
							requestTmp+="ville.nom='"+filter.get(f)+"'";
						}else if(attrib.equals("id_sport")) {
							requestTmp+="sport.libelle='"+filter.get(f)+"'";
						}else {
							requestTmp+="competition."+attrib+"='"+filter.get(f)+"'";
						}
						if(f!=filter.size()-1) {
							requestTmp+=" or ";
						}else {
							requestTmp+=") ";
						}
					}
				}
				request+=requestTmp;
				request+="order by competition.libelle;";
			}else if(tableView.equals("competition.equipe")) {
				String id=filters.get(0).get(0);
				request+="equipe.nom as e_nom, ville.nom as v_nom, equipe.id_equipe as e_id from inscription_equipe, equipe, ville where equipe.id_ville=ville.id_ville and equipe.id_equipe=inscription_equipe.id_equipe and inscription_equipe.id_competition="+id+" order by e_nom;";
				tableView="equipe";
			}
			rs=st.executeQuery(request);
			while(rs.next()) {
				if(tableView.equals("competiteur")) {
					out.add(new Cellule(rs.getString("prenom"), rs.getString("nom"), rs.getInt("id_competiteur")));
				}else if(tableView.equals("equipe")) {
					out.add(new Cellule(rs.getString("e_nom"), rs.getString("v_nom"), rs.getInt("e_id")));
				}else if(tableView.equals("competition")) {
					out.add(new Cellule(rs.getString("c_libelle"),rs.getString("c_type"),rs.getInt("c_id")));
				}
			}
		}
		return(out);
	}
	
	public int size(String table) throws SQLException {
		int nbr=0;
		if(st!=null) {
			String request = "select count(*) as nbr from "+table+";";
			rs = st.executeQuery(request);
			while(rs.next()) {nbr=rs.getInt("nbr");}
		}
		return(nbr);
	}
	
	public Map<String, ArrayList<String>> getCategories() throws SQLException{
		Map<String, ArrayList<String>> out=new Hashtable<String, ArrayList<String>>();
		String d="",table="";
		if(st!=null) {
			ArrayList<String> categories=new ArrayList<String>();
			categories.add("competiteur_sexe");
			categories.add("equipe_type");
			categories.add("ville_nom");
			categories.add("equipe_nom");
			categories.add("sport_nom");
			for(String c:categories) {
				ArrayList<String> data=new ArrayList<String>();
				if(c.equals("competiteur_sexe")) {d="sexe";table="competiteur";}
				else if(c.equals("equipe_type")) {d="type";table="equipe";}
				else if(c.equals("ville_nom")) {d="nom";table="ville";}
				else if(c.equals("equipe_nom")) {d="nom";table="equipe";}
				else if(c.equals("sport_nom")) {d="libelle";table="sport";}
				rs=st.executeQuery("select distinct "+d+" as "+c+" from "+table+" order by "+c+";");
				while(rs.next()) {
					data.add(rs.getString(c));
				}
				out.put(c, data);
			}
		}
		return(out);
	}
	
	public Boolean started(int id) throws SQLException {
		if(st!=null) {
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			String request="select if((select date_debut from competition where id_competition="+id+")<='"+formatter.format(date)+"',1,0) as ok;";
			rs = st.executeQuery(request);
			while(rs.next()) {if(rs.getInt("ok")==1) {return true;}}
			return false;
		}
		return true;
	}
	
	public ArrayList<Cellule> getCompetitionsForTeam(int id, String dates) throws SQLException{
		ArrayList<Cellule> out=new ArrayList<Cellule>();
		if(st!=null) {
			String request="select competition.libelle, ville.nom, competition.id_competition from inscription_equipe, competition, ville where inscription_equipe.id_competition=competition.id_competition and competition.id_ville=ville.id_ville and inscription_equipe.id_equipe="+id;
			if(!dates.equals("")) {
				request+=dates;
			}
			request+=";";
			rs = st.executeQuery(request);
			while(rs.next()) {
				out.add(new Cellule(rs.getString("libelle"),rs.getString("nom"),rs.getInt("id_competition")));
			}
		}
		return out;
	}

}