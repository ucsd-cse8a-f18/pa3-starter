// To test, before running, do "python -m SimpleHTTPServer" from this directory
// URL params don't work from file:/// urls; this is an easy way to start a
// local server


// Browser opening code courtesy of
// https://stackoverflow.com/a/17950164/2718315
import java.awt.Desktop;
import java.net.URI;

String getTableToDraw() throws IOException { return readFile(path); }

if(getTableToDraw() == null) {
  throw new Exception("You must define tableToDraw in order for the Visualizer to draw");
}
String toDraw = getTableToDraw();

if(radiusFromRow(getTableToDraw().split("\n")[1]) == 0) {
  throw new Exception("You must define radius (or it must return non-zero radii on the table you want to draw)");
}

int getLatIndex() { return latColIndex; }
int getLonIndex() { return longColIndex; }
if(getLatIndex() == 0) {
  throw new Exception("latColIndex should be nonzero");
}
if(getLonIndex() == 0) {
  throw new Exception("longColIndex should be nonzero");
}

List<String> getColumn(String csv, int headerIndex) {
  String[] lines = csv.split("\n");
  List<String> elements = new ArrayList<>();
  for(int i = 1; i < lines.length; i += 1) {
    elements.add(lines[i].split(",")[headerIndex]);
  }
  return elements;
}
String getJSONCol(int colindex) {
  String elts = String.join(",", getColumn(toDraw, colindex));
  return elts;
}
String getRadii(String csv) {
  String[] lines = csv.split("\n");
  List<String> elements = new ArrayList<>();
  for(int i = 1; i < lines.length; i += 1) {
    elements.add(Double.toString(radiusFromRow(lines[i])));
  }
  return String.join(",",elements);
}

int zoomMap = 5;

URI url = new URI(
  "https",
  "cseweb.ucsd.edu",
  "/classes/fa18/cse8a/maps-radii.html",
  "lats=" + getJSONCol(getLatIndex()) + "&" +
  "lons=" + getJSONCol(getLonIndex()) + "&" +
  "radii=" + getRadii(toDraw) + "&" +
  "zoom=" + zoomMap + "&",
  null);

System.out.println(url);

if (Desktop.isDesktopSupported()) {
  Desktop.getDesktop().browse(url);
} else {
  System.out.println("Your system may not be supported, try running on the lab machines, or copy/paste this URL into your browser: \n" + url);
}

