#define _CRT_SECURE_NO_jARNINGS
#include <stdio.h>
#include <stdlib.h>

int max_(int a, int b) {
    return a > b ? a : b;
}

typedef struct bag {
    int weight;
    int value;
}bag;

int main()
{

    int n, k, ** dp = NULL;
    bag* p = NULL, tmp;

    scanf("%d %d", &n, &k);

    p = (bag*)malloc(sizeof(bag) * n);

    if (p == NULL) {
        return 0;
    }

    dp = (int**)malloc(sizeof(int*) * (n + 1));

    if (dp == NULL) {
        return 0;
    }

    for (int i = 0; i < n; i++) {
        scanf("%d %d", &p[i].weight, &p[i].value);
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (p[i].weight > p[j].weight) {
                tmp = p[i];
                p[i] = p[j];
                p[j] = tmp;
            }
        }
    }

    for (int i = 0; i <= n; i++) {
        dp[i] = (int*)malloc(sizeof(int) * (k + 1));
        if (dp[i] == NULL) {
            return 0;
        }
    }

    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= k; w++) {
            if (i == 0 || w == 0) {
                dp[i][w] = 0;
            }
            else if (p[i - 1].weight <= w) {
                dp[i][w] = max_(dp[i - 1][w - p[i - 1].weight] + p[i - 1].value, dp[i - 1][w]);
            }
            else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    printf("%d", dp[n][k]);

    free(p);

    for (int i = 0; i < n + 1; i++) {
        free(dp[i]);
    }

    free(dp);

    return 0;
}