package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bal.BookCopyBAL;
import bal.CheckoutRecordBAL;
import bal.MemberBAL;
import entities.BookCopy;
import entities.CheckoutRecord;
import entities.Member;
import helper.RuleException;
import helper.RuleSet;
import helper.RuleSetFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckOutController implements Initializable {

	@FXML
	public TextField txtMemberID, txtIsbnNumber;

	@FXML
	public ComboBox<String> ddBookCopyNumber;

	@FXML
	private Button btnCheckIfAvailable, btnCheckOut, btnViewCheckoutRecord;

	@FXML
	private TableView<CheckoutRecord> table;
	private final static Alert alert = new Alert(Alert.AlertType.INFORMATION);

	public void checkOut() {

		CheckoutRecordBAL bal = new CheckoutRecordBAL();
		bal.addCheckOutRecord(ddBookCopyNumber.getValue(), txtMemberID.getText(), txtIsbnNumber.getText());
		loadCheckOutRecord();
		btnCheckOut.setVisible(false);
	}

	public void viewCheckOutRecord() {
		CheckoutRecordBAL bal = new CheckoutRecordBAL();
		bal.viewCheckOutRecord(txtMemberID.getText());
		alert.setHeaderText("Info!!!");
		alert.setContentText("Record is printed on console!!!");
		alert.showAndWait();
	}

	public void checkAvailable() {
		CheckoutRecordBAL bal = new CheckoutRecordBAL();
		String memberId = txtMemberID.getText();
		String ISBN = txtIsbnNumber.getText();

		try {
			RuleSet rules = RuleSetFactory.getRuleSet(CheckOutController.this);
			rules.applyRules(CheckOutController.this);
			if (bal.CheckIfAvailable(memberId, ISBN)) {
				btnCheckOut.setVisible(true);
				btnViewCheckoutRecord.setVisible(true);
				alert.setTitle("Found");
				alert.setHeaderText(
						"Member and Book both are valid. Please select copy number from the drop down and check out!!!");
				alert.showAndWait();
				loadBookCopyNumber(ISBN);

			} else {
				btnCheckOut.setVisible(false);
				btnViewCheckoutRecord.setVisible(false);
				alert.setTitle("Not Found");
				alert.setHeaderText("Match not found!!!");
				alert.showAndWait();
			}
		} catch (RuleException e) {

			alert.setTitle("Error!!!");
			alert.setHeaderText("Cannot lookup!!!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void loadBookCopyNumber(String isbn) {
		List<String> lst = new ArrayList<String>();
		BookCopyBAL copy = new BookCopyBAL();
		ddBookCopyNumber.getItems().clear();
		List<BookCopy> copyLst = copy.getListOfAvailableBook(isbn);

		for (BookCopy book : copyLst) {
			// System.out.println(book.getCopyNumber());
			lst.add(book.getCopyNumber());
		}
		if (lst.size() == 0) {
			alert.setTitle("Error!!!");
			alert.setHeaderText("No copies are available!!!");
			alert.setContentText("No copies are available!!!");
			alert.showAndWait();
		}
		ddBookCopyNumber.getItems().addAll(lst);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnCheckOut.setVisible(false);
		btnViewCheckoutRecord.setVisible(false);
		loadCheckOutRecord();

	}

	private void loadCheckOutRecord() {

		CheckoutRecordBAL mem = new CheckoutRecordBAL();
		List<CheckoutRecord> lstMember = mem.getCheckoutRecors();
		ObservableList data = FXCollections.observableList(lstMember);

		table.getColumns().clear();
		table.setEditable(true);

		TableColumn memberIdCol = new TableColumn<CheckoutRecord, String>("Member ID");
		memberIdCol.setMinWidth(50);
		memberIdCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("memberId"));

		TableColumn bookCopyNumberCol = new TableColumn<>("Book Copy Number");
		bookCopyNumberCol.setMinWidth(150);
		bookCopyNumberCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("bookCopyId"));

		TableColumn checkInDateCol = new TableColumn<>("Check In Date");
		checkInDateCol.setMinWidth(150);
		checkInDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("checkInDate"));

		TableColumn checkOutDateCol = new TableColumn<>("Check In Date");
		checkOutDateCol.setMinWidth(150);
		checkOutDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("checkOutdate"));

		TableColumn finePaidCol = new TableColumn<>("Fine Paid");
		finePaidCol.setMinWidth(150);
		finePaidCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("finePaid"));

		TableColumn finePaidDateCol = new TableColumn<>("Fine Paid Date");
		finePaidDateCol.setMinWidth(150);
		finePaidDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("finePaidDate"));

		TableColumn dueDateCol = new TableColumn<>("Due Date");
		dueDateCol.setMinWidth(150);
		dueDateCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("dueDate"));

		table.setItems(data);
		table.autosize();

		table.getColumns().addAll(memberIdCol, bookCopyNumberCol, checkOutDateCol, dueDateCol, checkInDateCol,
				finePaidCol, finePaidDateCol);
	}
}
