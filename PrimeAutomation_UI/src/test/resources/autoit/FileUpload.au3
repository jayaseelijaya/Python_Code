#include <ScreenCapture.au3>
$option = $CmdLine[4]
$filepath = $CmdLine[1]
$sspath =$CmdLine[2]
$sspath2 = $CmdLine[3]
ControlFocus("Select Folder to Upload","","Edit1")
if $option = "screenshot" Then
	popupIsDisplayed()
ElseIf $option = "cancel" Then
	clickCancelInPopUp()
ElseIf $option = "select file" Then
	selectFile()
	clickUploadInPopUp()
ElseIf $option = "alert screenshot" Then
	alertISDisplayed()
ElseIf $option = "upload" Then
	clickUploadInAlert()
ElseIf $option = "cancel alert" Then
	clickCancelInAlert()
EndIf
Exit


Func popupIsDisplayed()
	ControlFocus("Select Folder to Upload","","Edit1")
	Sleep(2000)
	Example()
EndFunc	

Func clickCancelInPopUp()
	ControlClick("Select Folder to Upload","","Button2")
EndFunc

Func selectFile()
	ControlSetText("Select Folder to Upload","","Edit1", $filepath)
	Sleep(2000)
	Example()
	Sleep(2000)
EndFunc

Func clickUploadInPopUp()
	ControlClick("Select Folder to Upload","","Button1")
	Sleep(2000)
EndFunc

Func alertISDisplayed()
	Example2()
EndFunc

Func clickUploadInAlert()
	Example2()
	Send("{Tab}")
	Send("{Enter}")
EndFunc

Func clickCancelInAlert()
	Example2()
	Send("{Enter}")
EndFunc

Func Example()
        Local $hBmp

        ; Capture full screen
        $hBmp = _ScreenCapture_Capture("")

        ; Save bitmap to file
        _ScreenCapture_SaveImage($sspath, $hBmp)
EndFunc   ;==>Example

    Func Example2()
        Local $hBmp

        ; Capture full screen
        $hBmp = _ScreenCapture_Capture("")

        ; Save bitmap to file
        _ScreenCapture_SaveImage($sspath2, $hBmp)
EndFunc   ;==>Example