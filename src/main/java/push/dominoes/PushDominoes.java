package push.dominoes;

/**
 * @author hum
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char prev = 'L';
        int index = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            while (i < len && dominoes.charAt(i) == '.') {
                i++;
            }
            if (i == len) {
                break;
            }
            if (dominoes.charAt(i) == 'L') {
                if (prev == 'L') {
                    for (int j = index + 1; j <= i; j++) {
                        result.append('L');
                    }
                } else {
                    for (int j = 0; j < (i - index + 1) / 2; j++) {
                        result.append('R');
                    }
                    if ((i - index + 1) % 2 != 0) {
                        result.append('.');
                    }
                    for (int j = 0; j < (i - index + 1) / 2; j++) {
                        result.append('L');
                    }
                }
                prev = 'L';
                index = i;
            } else if (dominoes.charAt(i) == 'R') {
                if (prev == 'R') {
                    for (int j = index; j < i; j++) {
                        result.append('R');
                    }
                } else {
                    for (int j = index + 1; j < i; j++) {
                        result.append('.');
                    }
                }
                prev = 'R';
                index = i;
            }
        }
        if (prev == 'R') {
            for (int i = index; i < len; i++) {
                result.append('R');
            }
        } else {
            for (int i = index + 1; i < len; i++) {
                result.append('.');
            }
        }

        return result.toString();
    }
}
