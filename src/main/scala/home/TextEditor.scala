package home

import scala.swing._

/**
 * Simple Text Editor Application made with Swing!
 *
 */
object TextEditor extends App {


  val textArea = new TextArea



    //GUI App Code starts here

    val frame = new MainFrame {
      title = "My first GUI-APP as TextEditor"
      contents = textArea
      size = new Dimension(500,500)
      centerOnScreen()
      menuBar = new MenuBar {
        contents += new Menu("File") {
          contents += new MenuItem(Action("Open"){
            openFile()

          })
          contents += new MenuItem(Action("Save") {
            saveFile()
          })
          contents += new Separator
          contents += new MenuItem(Action("Exit"){
            sys.exit(0)
          })

        }
        contents += new Menu("Extra"){
          contents += new MenuItem(Action("About") {
            val frametwo = new MainFrame {

              title = "About this programme"
              contents = new Label("This programme was wirtten by: 'Amar Bajric' on 8th of November 2015")
              size = new Dimension(600,200)
              centerOnScreen() }
            frametwo.visible = true
          })
        }
      }
    }



    //here are methods(functions) who are called by the Action-operator
    def openFile() {
      val chooser = new FileChooser
      if (chooser.showOpenDialog(null) == FileChooser.Result.Approve) {
        val source = scala.io.Source.fromFile(chooser.selectedFile)
        textArea.text = source.mkString
        source.close()
      }
    }



    def saveFile() {
      val chooser = new FileChooser
      if (chooser.showSaveDialog(null) == FileChooser.Result.Approve) {
        val pw = new java.io.PrintWriter(chooser.selectedFile)
        pw.print(textArea.text)
        pw.close()
      }

    }

    // to show an window this line of code is needed...so in order to make the MainFrame at the value "frame" visible this must hold a true Boolean.
    frame.visible = true

  }




















}

