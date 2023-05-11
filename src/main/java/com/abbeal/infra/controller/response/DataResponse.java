package com.abbeal.infra.controller.response;

import java.util.List;

public record DataResponse(int rank, int points, int weight, int height, int age, List<Integer> last) {
}
