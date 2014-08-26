package chapter06.io

/**
 * @author tanabe
 */
object PathSample extends App {

  def path() = {
    println("-- Path のインスタンスの生成 --")

    import scalax.file.Path

    val filePath = Path("hoge.txt")
    println(filePath)

    val dirPath = Path("foo", "bar")
    println(dirPath)

    val subdirPath = dirPath / Path("hoge")
    println(subdirPath)

    val path = Path("foo/bar", '/')
    println(path)
  }
  path()

  def create() = {
    println("-- ファイル、ディレクトリの作成 --")

    import scalax.file.Path

    val filePath = Path("hoge.txt")
    filePath.createFile()

    val dirPath = Path("foo", "bar")
    dirPath.createDirectory()

    val path = Path("foo", "bar", "hoge.txt")
    path.createFile(createParents = false, failIfExists = false)
  }
  create()

  def delete() = {
    println("-- ファイル、ディレクトリの削除 --")

    import scalax.file.Path

    val filePath = Path("hoge.txt")
    filePath.delete()

    val dirPath = Path("foo")
    dirPath.deleteRecursively()
  }
  delete()

  def copy() = {
    println("-- ファイル、ディレクトリの移動/コピー --")

    import scalax.file.Path

    val from = Path("foo.txt")
    from.createFile()

    val to = Path("foo", "bar.txt")

    from.copyTo(to)

    from.copyTo(to, replaceExisting = true)
    to.delete()

    from.copyTo(to, createParents = false)
    Path("foo").deleteRecursively()

    from.moveTo(to)

    from.createFile()
    from.moveTo(to, replace = true)

    Path("foo").deleteRecursively()
  }
  copy()

  def listFiles() = {
    println("-- ディレクトリ内のファイル、ディレクトリの一覧の取得 --")

    import scalax.file.Path
    import scalax.file.PathSet

    val children: PathSet[Path] = Path(".").children()
    children.foreach { child =>
      println(child)
    }

    println("-- 特定の条件を満たすファイルのみ表示 --")

    val filtered = Path(".").children().filter { file =>
      file.isFile && file.name.endsWith(".bat")
    }
    filtered.foreach(println)
  }
  listFiles()

  def parentDir() = {
    println("-- 親ディレクトリの取得 --")

    import scalax.file.Path

    val path = Path().toAbsolute

    val parent: Option[Path] = path.toAbsolute.parent

    parent match {
      case Some(x) => println(x.path)
      case None => println("parent directory does not exist.")
    }
  }
  parentDir()

  def attribute() = {
    println("-- ファイル、ディレクトリの属性を調べる --")

    import scalax.file.Path

    def printAttributes(path: Path) = {
      println("ファイルかどうか: " + path.isFile)
      println("ディレクトリかどうか: " + path.isDirectory)
      println("隠しファイルかどうか: " + path.isHidden)
      println("シンボリックリンクかどうか: " + path.isSymlink)
      println("読み取り可能かどうか: " + path.canRead)
      println("書き込み可能かどうか: " + path.canWrite)
      println("実行可能かどうか: " + path.canExecute)
      println("存在するかどうか: " + path.exists)

      println("最終更新日時: " + new java.util.Date(path.lastModified))

      println("ファイルサイズ: " + path.size)
    }

    printAttributes(Path("."))
    printAttributes(Path("build.sbt"))
    printAttributes(Path(".gitignore"))
  }
  attribute()

  def accessMode() = {
    println("-- ファイル、ディレクトリのアクセスモード --")

    import scalax.file.Path
    import scalax.file.Path.AccessModes._

    val path = Path("LICENSE")

    println(path.access)

    path.access -= Write
    path.access -= Read
    path.access += Execute
    println(path.access)

    path.access = "rw"
    println(path.access)
  }

  accessMode()
}
