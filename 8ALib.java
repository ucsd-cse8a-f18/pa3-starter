import java.time.*;
import java.text.*

int square(int n) {
  return n*n;
}

int sign(int n) {
  if(n > 0) { return 1; }
  if(n < 0) { return -1; }
  return 0;
}

int roundTo(int n, int toRoundTo) {
  final int magRoundTo = Math.abs(toRoundTo);
  final int rem = Math.abs(n) % magRoundTo;
  final int multiple = Math.abs(n)/ magRoundTo;
  final int sign = n>=0?1:-1;
  if ( rem > (magRoundTo/2) ) {
    return (magRoundTo*(multiple+1)*sign);
  }
  else {
    return (magRoundTo*multiple*sign);
  }
}

int length(String s) {
  return s.length();
}

String substring(String base, int beginIndex, int endIndex) {
  return base.substring(beginIndex, endIndex);
}

String concat(String left, String right) {
  return left + right;
}

int indexOf(String base, String toFind) {
  return base.indexOf(toFind);
}

int indexOfNth(String base, String toFind, int n) {
  final int lenToFind = length(toFind);
  int baseIndex = 0;
  String baseSuffix = base;
  for (int toFindCounter=0; toFindCounter<=n; toFindCounter++) {
    int currIndex= indexOf(baseSuffix,toFind);
    if (currIndex == -1) {
      return -1;
    }
    else {
      baseIndex += currIndex;
      baseSuffix = substring(baseSuffix,currIndex+lenToFind,length(baseSuffix));
    }
  }
  return baseIndex + n * lenToFind;
}

int parseInt(String s) {
  return Integer.parseInt(s);
}
double parseDouble(String s) {
  return Double.parseDouble(s);
}
long parseLong(String s) {
  return Long.parseLong(s);
}

String readLine(String path, int index) throws java.io.IOException {
  final Path filePath = Paths.get(path);
  final List<String> contents = Files.readAllLines(filePath);
  return contents.get(index);
}

int count(String base, String toFind) {
  if (toFind.isEmpty()) {
    throw new java.lang.IllegalArgumentException("toFind argument of count method must be nonempty string");
  }
  int count = 0;
  String suffix = base;
  while (!suffix.isEmpty()) {
    int indexToFind = indexOf(suffix,toFind);
    if(indexToFind == -1) {
      return count;
    }
    else {
      count += 1;
      suffix = substring(suffix, indexToFind+1, length(suffix));
    }
  }
  return count;
}

// NOTE(joe): The cast to integer is safe until 2038,
// See: https://en.wikipedia.org/wiki/Year_2038_problem
// NOTE(mia): Sadly, no.  The dates in the potholes file overflow.
// Changed to long.

long dateMonthDayYearTime(String date) {
  try {
    final DateFormat d = new SimpleDateFormat("MMMMM dd yyyy hh:mm z");
    return (long)d.parse(date).getTime();
  } catch(java.text.ParseException e) {
    throw new IllegalArgumentException(e.toString());
  }
}

long dateYearMonthDayTime(String date) {
  try {
    final DateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    return (long)d.parse(date).getTime();
  } catch(java.text.ParseException e) {
    throw new IllegalArgumentException(e.toString());
  }
}

long dateYearMonthDayTime(String date) {
  if(date.equals("")) { return System.currentTimeMillis(); }
  try {
    final DateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    return (long)d.parse(date).getTime();
  } catch(java.text.ParseException e) {
    throw new IllegalArgumentException(e.toString());
  }
}


boolean show(String s, int numLines) {
  final String[] lines = s.split("\n");
  for(int i = 0; i < numLines; i += 1) {
    if(numLines >= lines.length) { return false; }
    System.out.println(lines[i]);
  }
  return true;
}

String readFile(String path) throws java.io.IOException {
  final Path filePath = Paths.get(path);
  final List<String> contents = Files.readAllLines(filePath);
  StringBuilder result = new StringBuilder();
  for(String s: contents) { result.append(s + "\n"); }
  return result.toString();
}

String intToString(int n) {
  return Integer.toString(n);
}

double intToDouble(int n) {
  return (double)n;
}

String doubleToString(double d) {
  return Double.toString(d);
}

String trim(String s) {
  return s.trim();
}

boolean stringEquals(String s1, String s2) {
  return s1.equals(s2);
}


double sin(double n) {
  return Math.sin(n);
}

double cos(double n) {
  return Math.cos(n);
}

double tan(double n) {
  return Math.tan(n);
}

double sqrt(double n) {
  return Math.sqrt(n);
}

double pow(double base, double expt) {
  return Math.pow(base, expt);
}
