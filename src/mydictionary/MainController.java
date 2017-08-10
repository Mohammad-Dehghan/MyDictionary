package mydictionary;

import kernel.db.DB;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mohammad Dehghan
 */
public class MainController implements Initializable {

    @FXML
    Button new_word;
    @FXML
    Button search;
    @FXML
    ComboBox<String> search_lang;
    @FXML
    TextField search_box;
    private String fa_str;
    private String en_str;
    private String deu_str;
    private String arab_str;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search_lang.getItems().add("پارسی");
        search_lang.getItems().add("English");
        search_lang.getItems().add("Deutch(Germany)");
        search_lang.getItems().add("العربیة");
    }

    public void new_word(ActionEvent event) {
        try {
            MyDictionary.replaceSceneContent("New.fxml");
        } catch (Exception ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void update_english(ArrayList<String> words) {
        try {
            for (String word : words) {
                ResultSet r0 = DB.getDB().statement.executeQuery(
                        "select d.deu_word from fa as f,deu as d, fa_deu as fd "
                        + "where f.fa_word='" + word + "' and f.fa_id=fd.fa_id "
                        + "and fd.deu_id=d.deu_id;");
                while (r0.next()) {
                    String str = r0.getString("deu_word");
                    deu_str = deu_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,deu as d, fa_deu as fd "
                            + "where d.deu_word='" + str + "' and d.deu_id=fd.deu_id "
                            + "and fd.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
                r0 = DB.getDB().statement.executeQuery(
                        "select e.arab_word from fa as f,arab as e, fa_arab as fe "
                        + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                        + "and fe.arab_id=e.arab_id;");
                while (r0.next()) {
                    String str = r0.getString("arab_word");
                    arab_str = arab_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,arab as a, fa_arab as fr "
                            + "where a.arab_word='" + str + "' and a.arab_id=fr.arab_id "
                            + "and fr.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
            }
        } catch (SQLException ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void update_deutch(ArrayList<String> words) {
        try {
            for (String word : words) {
                ResultSet r0 = DB.getDB().statement.executeQuery(
                        "select e.en_word from fa as f,en as e, fa_en as fe "
                        + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                        + "and fe.en_id=e.en_id;");
                while (r0.next()) {
                    String str = r0.getString("en_word");
                    en_str = en_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,en as e, fa_en as fe "
                            + "where e.en_word='" + str + "' and e.en_id=fe.en_id "
                            + "and fe.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
                r0 = DB.getDB().statement.executeQuery(
                        "select e.arab_word from fa as f,arab as e, fa_arab as fe "
                        + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                        + "and fe.arab_id=e.arab_id;");
                while (r0.next()) {
                    String str = r0.getString("arab_word");
                    arab_str = arab_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,arab as a, fa_arab as fr "
                            + "where a.arab_word='" + str + "' and a.arab_id=fr.arab_id "
                            + "and fr.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
            }
        } catch (SQLException ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void update_arab(ArrayList<String> words) {
        try {
            for (String word : words) {
                ResultSet r0 = DB.getDB().statement.executeQuery(
                        "select e.en_word from fa as f,en as e, fa_en as fe "
                        + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                        + "and fe.en_id=e.en_id;");
                while (r0.next()) {
                    String str = r0.getString("en_word");
                    en_str = en_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,en as a, fa_en as fr "
                            + "where a.en_word='" + str + "' and a.en_id=fr.en_id "
                            + "and fr.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
                r0 = DB.getDB().statement.executeQuery(
                        "select d.deu_word from fa as f,deu as d, fa_deu as fd "
                        + "where f.fa_word='" + word + "' and f.fa_id=fd.fa_id "
                        + "and fd.deu_id=d.deu_id;");
                while (r0.next()) {
                    String str = r0.getString("deu_word");
                    deu_str = deu_str + "" + str + ", ";
                    ResultSet r1 = DB.getDB().statement.executeQuery("select f.fa_word from fa as f,deu as d, fa_deu as fd "
                            + "where d.deu_word='" + str + "' and d.deu_id=fd.deu_id "
                            + "and fd.fa_id=f.fa_id;");
                    while (r1.next()) {
                        fa_str = fa_str + "" + r1.getString("fa_word") + ", ";
                    }
                }
            }
        } catch (SQLException ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void search(ActionEvent event) {
        try {
            String word = search_box.getText();
            String lang = search_lang.getValue();
            if (word.isEmpty() || word.equals("") || word.equals(" ")) {
                //Notify.createAlert("کلمه‌ای برای جست‌وجو وارد کنید", Alert.AlertType.WARNING);
            } else {
                word = word.toLowerCase();
                fa_str = "";
                en_str = "";
                deu_str = "";
                arab_str = "";
                String tmp;
                ResultSet rs;
                ArrayList<String> words;
                switch (lang) {
                    case "پارسی":
                        rs = DB.getDB().statement.executeQuery(
                                "select e.en_word from fa as f,en as e, fa_en as fe "
                                + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                                + "and fe.en_id=e.en_id;");
                        while (rs.next()) {
                            en_str = en_str + "" + rs.getString("en_word") + ", ";
                        }
                        rs = DB.getDB().statement.executeQuery(
                                "select d.deu_word from fa as f,deu as d, fa_deu as fd "
                                + "where f.fa_word='" + word + "' and f.fa_id=fd.fa_id "
                                + "and fd.deu_id=d.deu_id;");
                        while (rs.next()) {
                            deu_str = deu_str + "" + rs.getString("deu_word") + ", ";
                        }
                        rs = DB.getDB().statement.executeQuery(
                                "select e.arab_word from fa as f,arab as e, fa_arab as fe "
                                + "where f.fa_word='" + word + "' and f.fa_id=fe.fa_id "
                                + "and fe.arab_id=e.arab_id;");
                        while (rs.next()) {
                            arab_str = arab_str + "" + rs.getString("arab_word") + ", ";
                        }
                        break;
                    case "English":
                        words = new ArrayList<>();
                        rs = DB.getDB().statement.executeQuery(
                                "select f.fa_word from fa as f,en as e, fa_en as fe "
                                + "where e.en_word='" + word + "' and e.en_id=fe.en_id "
                                + "and fe.fa_id=f.fa_id;");
                        while (rs.next()) {
                            tmp = rs.getString("fa_word");
                            fa_str = fa_str + "" + tmp + ", ";
                            words.add(tmp);
                        }
                        update_english(words);
                        break;
                    case "Deutch(Germany)":
                        words = new ArrayList<>();
                        rs = DB.getDB().statement.executeQuery(
                                "select f.fa_word from fa as f,deu as d, fa_deu as fd "
                                + "where d.deu_word='" + word + "' and d.deu_id=fd.deu_id "
                                + "and fd.fa_id=f.fa_id;");
                        while (rs.next()) {
                            tmp = rs.getString("fa_word");
                            fa_str = fa_str + "" + tmp + ", ";
                            words.add(tmp);
                        }
                        update_deutch(words);
                        break;
                    case "العربیة":
                        words = new ArrayList<>();
                        rs = DB.getDB().statement.executeQuery(
                                "select f.fa_word from fa as f,arab as a, fa_arab as fr "
                                + "where a.arab_word='" + word + "' and a.arab_id=fr.arab_id "
                                + "and fr.fa_id=f.fa_id;");
                        while (rs.next()) {
                            tmp = rs.getString("fa_word");
                            fa_str = fa_str + "" + tmp + ", ";
                            words.add(tmp);
                        }
                        update_arab(words);
                        break;
                    default:
                        //Notify.createAlert("نوع زبان برای جست‌وجو انتخاب نشده است", Alert.AlertType.ERROR);
                        break;
                }
//                fa_result.setText(fa_str);
//                en_result.setText(en_str);
//                deu_result.setText(deu_str);
//                arab_result.setText(arab_str);
            }
        } catch (SQLException ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
