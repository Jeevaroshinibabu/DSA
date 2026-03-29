/**
 * Note: The returned array must be malloced, assume caller calls free().
 */


int* recoverOrder(int* order, int orderSize, int* friends, int friendsSize, int* returnSize) {
    // Maximum possible size is the smaller of the two arrays
    int maxPossible = (orderSize < friendsSize) ? orderSize : friendsSize;
    int* a = (int*)malloc(maxPossible * sizeof(int));
    if (!a) {
        *returnSize = 0;
        return NULL;
    }

    int n = 0;
    for (int i = 0; i < orderSize; ++i) {
        for (int j = 0; j < friendsSize; ++j) {
            if (order[i] == friends[j]) {
                // Avoid duplicates in the result
                int already = 0;
                for (int k = 0; k < n; ++k) {
                    if (a[k] == order[i]) { already = 1; break; }
                }
                if (!already) {
                    a[n++] = order[i];
                }
                break;
            }
        }
    }

    // Optional: shrink to actual size
    int* result = (n > 0) ? (int*)realloc(a, n * sizeof(int)) : NULL;
    if (n == 0) {
        free(a);
        result = NULL;
    }

    *returnSize = n;
    return result;
}