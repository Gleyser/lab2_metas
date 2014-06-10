name := "Metas"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
	cache,
	javaJpa,
	"org.apache.directory.api" % "apiall"
	% "1.0.0M14",
	"postgresql" % "postgresql" % "9.19011.
	jdbc4",
	"org.hibernate" % "hibernatecore"
	% "4.2.3.Final",
	"org.hibernate" % "hibernateentitymanager"
	% "4.2.3.Final"
)     

play.Project.playJavaSettings
