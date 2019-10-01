package com.ccu.model;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.Vector;

public class MyTableModel extends AbstractTableModel {
    private Vector rowDate = new Vector();
    private Vector<String> columName = new Vector<String>();

    public MyTableModel(){

    }

    public MyTableModel(Vector rowDate, Vector<String> columName) {
        this.rowDate = rowDate;
        this.columName = columName;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.rowDate.size();
    }

    @Override
    public int getColumnCount() {
        return this.columName.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector) (this.rowDate.get(rowIndex))).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return this.columName.get(column);
    }



    public void Update(ResultSet rs){
        this.rowDate = new Vector();
        try {
            while(rs.next()){
                Vector h = new Vector();
                h.add(rs.getInt("Number"));
                h.add(rs.getString("UserName"));
                h.add(rs.getString("Password"));
                h.add(rs.getInt("Rank"));
                h.add(rs.getString("Phone"));
                rowDate.add(h);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }


    }

    public void Updategoods(ResultSet rs){
        this.rowDate = new Vector();
        try {
            while(rs.next()){
                Vector h = new Vector();
                h.add(rs.getInt("GoodsId"));
                h.add(rs.getString("GoodsName"));
                h.add(rs.getString("Classification"));
                h.add(rs.getInt("Price"));
                h.add(rs.getString("Stock"));
                rowDate.add(h);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void UpdategoodsClass(ResultSet rs){
        this.rowDate = new Vector();
        try {
            while(rs.next()){
                Vector h = new Vector();
                h.add(rs.getString("ClassificationNum"));
                h.add(rs.getString("Classification"));
                rowDate.add(h);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void Updateorders(ResultSet rs){
        this.rowDate = new Vector();
        try {
            while(rs.next()){
                Vector h = new Vector();
                h.add(rs.getInt("Onumber"));
                h.add(rs.getString("GoodsName"));
                h.add(rs.getInt("GoodsNum"));
                h.add(rs.getDouble("Prices"));
                h.add(rs.getString("User"));
                h.add(rs.getString("OrderDate"));
                rowDate.add(h);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
