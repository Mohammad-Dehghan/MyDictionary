package mydictionary;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mohammad Dehghan
 */
public class NewController implements Initializable {

    @FXML
    TextField new_field;
    @FXML
    ComboBox<String> new_lang;
    @FXML
    AnchorPane fa;
    @FXML
    TextField fa1;
    @FXML
    TextField fa2;
    @FXML
    TextField fa3;
    @FXML
    TextField fa4;
    @FXML
    TextField fa5;
    @FXML
    TextField fa6;
    @FXML
    TextField fa7;
    @FXML
    TextField fa8;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new_lang.getItems().add("English");
        new_lang.getItems().add("Deutch(Germany)");
        new_lang.getItems().add("العربیة");
    }

    public void Save(ActionEvent event) {
        try {
            String str = new_lang.getValue();
            String word = new_field.getText();
            if (!word.trim().isEmpty()) {
                word = word.toLowerCase();
                ArrayList<String> words;
                int id;
                ArrayList<Integer> idxs;
                int flag;
                switch (str) {
                    case "English":
                        words = new ArrayList<>();
                        idxs = new ArrayList<>();
                        words.add(fa1.getText());
                        words.add(fa2.getText());
                        words.add(fa3.getText());
                        words.add(fa4.getText());
                        words.add(fa5.getText());
                        words.add(fa6.getText());
                        words.add(fa7.getText());
                        words.add(fa8.getText());
                        flag = 8;
                        for (String word1 : words) {
                            if (!word1.trim().isEmpty()) {
                                ResultSet rs = DB.getDB().statement.executeQuery("select fa_word from fa where fa_word='" + word1 + "';");
                                if (!rs.next()) {
                                    DB.getDB().statement.executeUpdate("insert into fa(fa_word) values('" + word1 + "');");
                                    ResultSet rs2 = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs2.next()) {
                                        idxs.add(rs2.getInt("fa_id"));
                                    }
                                } else {
                                    ResultSet rs2 = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs2.next()) {
                                        idxs.add(rs2.getInt("fa_id"));
                                    }
                                }
                            } else {
                                flag--;
                            }
                        }
                        if (flag <= 0) {
                            throw new Exception("باید معادل پارسی لغت را وارد کنید");
                        } else {
                            ResultSet rs = DB.getDB().statement.executeQuery("select en_id from en where en_word='" + word + "';");
                            if (!rs.next()) {
                                DB.getDB().statement.executeUpdate("insert into en(en_word) values('" + word + "');");
                                ResultSet r0 = DB.getDB().statement.executeQuery("select en_id from en where en_word='" + word + "';");
                                r0.next();
                                id = r0.getInt("en_id");
                            } else {
                                id = rs.getInt("en_id");
                            }
                            for (Integer idx : idxs) {
                                if (DB.getDB().statement.execute("insert into fa_en(fa_id, en_id) values(" + idx + ", " + id + ");")) {
                                    //
                                }
                            }
                        }
                        Notify.createAlert("با موفقیت اضافه شد", Alert.AlertType.INFORMATION);
                        break;
                    case "Deutch(Germany)":
                        words = new ArrayList<>();
                        idxs = new ArrayList<>();
                        words.add(fa1.getText());
                        words.add(fa2.getText());
                        words.add(fa3.getText());
                        words.add(fa4.getText());
                        words.add(fa5.getText());
                        words.add(fa6.getText());
                        words.add(fa7.getText());
                        words.add(fa8.getText());
                        flag = 8;
                        for (String word1 : words) {
                            if (!word1.trim().isEmpty()) {
                                ResultSet rs = DB.getDB().statement.executeQuery("select fa_word from fa where fa_word='" + word1 + "';");
                                if (!rs.next()) {
                                    DB.getDB().statement.executeUpdate("insert into fa(fa_word) values('" + word1 + "');");
                                    ResultSet rs1 = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs1.next()) {
                                        idxs.add(rs1.getInt("fa_id"));
                                    }
                                } else {
                                    ResultSet rs2 = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs2.next()) {
                                        idxs.add(rs2.getInt("fa_id"));
                                    }
                                }
                            } else {
                                flag--;
                            }
                        }
                        if (flag <= 0) {
                            throw new Exception("باید معادل پارسی لغت را وارد کنید");
                        } else {
                            ResultSet rs = DB.getDB().statement.executeQuery("select deu_id from deu where deu_word='" + word + "';");
                            if (!rs.next()) {
                                DB.getDB().statement.executeUpdate("insert into deu(deu_word) values('" + word + "');");
                                ResultSet r0 = DB.getDB().statement.executeQuery("select deu_id from deu where deu_word='" + word + "';");
                                r0.next();
                                id = r0.getInt("deu_id");
                            } else {
                                id = rs.getInt("deu_id");
                            }
                            for (Integer idx : idxs) {
                                if (DB.getDB().statement.execute("insert into fa_deu(fa_id, deu_id) values(" + idx + ", " + id + ");")) {
                                    //
                                }
                            }
                        }
                        Notify.createAlert("با موفقیت اضافه شد", Alert.AlertType.INFORMATION);
                        break;
                    case "العربیة":
                        words = new ArrayList<>();
                        idxs = new ArrayList<>();
                        words.add(fa1.getText());
                        words.add(fa2.getText());
                        words.add(fa3.getText());
                        words.add(fa4.getText());
                        words.add(fa5.getText());
                        words.add(fa6.getText());
                        words.add(fa7.getText());
                        words.add(fa8.getText());
                        flag = 8;
                        for (String word1 : words) {
                            if (!word1.trim().isEmpty()) {
                                ResultSet rs = DB.getDB().statement.executeQuery("select fa_word from fa where fa_word='" + word1 + "';");
                                if (!rs.next()) {
                                    DB.getDB().statement.executeUpdate("insert into fa(fa_word) values('" + word1 + "');");
                                    rs = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs.next()) {
                                        idxs.add(rs.getInt("fa_id"));
                                    }
                                } else {
                                    ResultSet rs2 = DB.getDB().statement.executeQuery("select fa_id from fa where fa_word='" + word1 + "';");
                                    if (rs2.next()) {
                                        idxs.add(rs2.getInt("fa_id"));
                                    }
                                }
                            } else {
                                flag--;
                            }
                        }
                        if (flag <= 0) {
                            throw new Exception("باید معادل پارسی لغت را وارد کنید");
                        } else {
                            ResultSet rs = DB.getDB().statement.executeQuery("select arab_id from arab where arab_word='" + word + "';");
                            if (!rs.next()) {
                                DB.getDB().statement.executeUpdate("insert into arab(arab_word) values('" + word + "');");
                                ResultSet r0 = DB.getDB().statement.executeQuery("select arab_id from arab where arab_word='" + word + "';");
                                r0.next();
                                id = r0.getInt("arab_id");
                            } else {
                                id = rs.getInt("arab_id");
                            }
                            for (Integer idx : idxs) {
                                if (DB.getDB().statement.execute("insert into fa_arab(fa_id, arab_id) values(" + idx + ", " + id + ");")) {
                                    //
                                }
                            }
                        }
                        Notify.createAlert("با موفقیت اضافه شد", Alert.AlertType.INFORMATION);
                        break;
                }
            }
            fa1.setText("");
            fa2.setText("");
            fa3.setText("");
            fa4.setText("");
            fa5.setText("");
            fa6.setText("");
            fa7.setText("");
            fa8.setText("");
            new_field.setText("");
        } catch (SQLException ex) {
            Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception ex) {
            Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void Back(ActionEvent event) {
        try {
            MyDictionary.replaceSceneContent("Main.fxml");
        } catch (Exception ex) {
            Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
