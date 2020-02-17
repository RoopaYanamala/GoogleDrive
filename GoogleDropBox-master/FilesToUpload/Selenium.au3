WinWait("[CLASS:#32770]","",5)
ControlFocus("Open","","Edit1")
Sleep(2000)
ControlSetText("Open", "", "Edit1", $CmdLine[1])
Sleep(1000)
Sleep(1000)
ControlClick("Open", "","Button1");