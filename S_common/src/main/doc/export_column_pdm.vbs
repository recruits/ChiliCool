Option Explicit

   Dim rowsNum

   rowsNum = 0

'-----------------------------------------------------------------------------

' Main function

'-----------------------------------------------------------------------------

' Get the current active model

Dim Model

Set Model = ActiveModel

If (Model Is Nothing) Or (Not Model.IsKindOf(PdPDM.cls_Model)) Then

  MsgBox "The current model is not an PDM model."

Else

 ' Get the tables collection

 '创建EXCEL APP

 dim beginrow

 DIM EXCEL, SHEET

 set EXCEL = CREATEOBJECT("Excel.Application")

 EXCEL.workbooks.add(-4167)'添加工作表

 EXCEL.workbooks(1).sheets(1).name ="水路运输建设综合管理信息系统"

 set sheet = EXCEL.workbooks(1).sheets("水路运输建设综合管理信息系统")

 

 ShowProperties Model, SHEET

 EXCEL.visible = true

 '设置列宽和自动换行
 
 sheet.Columns(1).ColumnWidth = 20
 sheet.Columns(2).ColumnWidth = 20

 sheet.Columns(3).ColumnWidth = 20

 sheet.Columns(4).ColumnWidth = 20

 sheet.Columns(1).WrapText =true
 sheet.Columns(2).WrapText =true
 sheet.Columns(3).WrapText =true
 sheet.Columns(4).WrapText =true

 End If

'-----------------------------------------------------------------------------

' Show properties of tables

'-----------------------------------------------------------------------------

Sub ShowProperties(mdl, sheet)

   ' Show tables of the current model/package

   rowsNum=0

   beginrow = rowsNum+1

   ' For each table

   output "begin"

   Dim tab
   Dim pck
   For Each pck in mdl.packages
	'如果要导出PDM中所有的表，需要注释下面的 if ** then 和 end if
	'如果按模块导出请修改下面的包名，举例：导出PDM中客服管理包下的表
	'if pck.name = "00-基础数据" then 
      For Each tab In pck.tables

         ShowTable tab,sheet
      
      Next
    'end if 
   Next

   if mdl.tables.count > 0 then

        sheet.Range("A" & beginrow + 1 & ":A" & rowsNum).Rows.Group

   end if

   output "end"

End Sub

'-----------------------------------------------------------------------------

' Show table properties

'-----------------------------------------------------------------------------

Sub ShowTable(tab, sheet)

   If IsObject(tab) Then

     Dim rangFlag

      Output "================================"

      	Dim col ' running column

		Dim colsNum

		colsNum = 0

      for each col in tab.columns

        rowsNum = rowsNum + 1
		
        colsNum = colsNum + 1
		
		sheet.cells(rowsNum, 1) = tab.code
		
		sheet.cells(rowsNum, 2) = col.code
		
		sheet.cells(rowsNum, 3) = col.name
		
		sheet.cells(rowsNum, 4) = col.datatype
      
      next

      sheet.Range(sheet.cells(rowsNum-colsNum+1,1),sheet.cells(rowsNum,4)).Borders.LineStyle = "2"       

      Output "FullDescription: "       + tab.Name

   End If

End Sub
