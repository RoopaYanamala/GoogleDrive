WinWait("[CLASS:#32770]","",5)
ControlFocus("Open","","Edit1")
Sleep(2000)
ControlSetText("Open", "", "Edit1", "C:\WorkSpace\Java\GoogleDropBox\FilesToUpload\Cucumber.txt")
Sleep(1000)
Sleep(1000)
ControlClick("Open", "","Button1");