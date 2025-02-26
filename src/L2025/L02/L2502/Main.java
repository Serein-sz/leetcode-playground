package L2025.L02.L2502;

import utils.ArrayUtils;

import java.util.*;

/**
 * @author 王强
 * @since 2025/2/25
 */
public class Main {
    public static void main(String[] args) {
        Allocator loc = new Allocator(10);
        // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
        int result = loc.allocate(1, 1);
        System.out.println("0: " + result);
        ArrayUtils.println(loc.memory);
        // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        result = loc.allocate(1, 2);
        System.out.println("1: " + result);
        ArrayUtils.println(loc.memory);
        // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        result = loc.allocate(1, 3);
        System.out.println("2: " + result);
        ArrayUtils.println(loc.memory);
        // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        result = loc.freeMemory(2);
        System.out.println("1: " + result);
        ArrayUtils.println(loc.memory);
        // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        result = loc.allocate(3, 4);
        System.out.println("3: " + result);
        ArrayUtils.println(loc.memory);
        // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        result = loc.allocate(1, 1);
        System.out.println("1: " + result);
        ArrayUtils.println(loc.memory);
        // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        result = loc.allocate(1, 1);
        System.out.println("6: " + result);
        ArrayUtils.println(loc.memory);
        // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        result = loc.freeMemory(1);
        System.out.println("3: " + result);
        ArrayUtils.println(loc.memory);
        // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        result = loc.allocate(10, 2);
        System.out.println("-1: " + result);
        // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
        result = loc.freeMemory(7);
        System.out.println("0: " + result);
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
class Allocator {

    public final int[] memory;

    private final Map<Integer, List<Integer>> mapper = new HashMap<>();

    public Allocator(int n) {
        memory = new int[n];
        Arrays.fill(memory, 0);
    }

    public int allocate(int size, int mID) {
        if (size > memory.length) {
            return -1;
        }
        int left = 0;
        while (left < memory.length) {
            if (memory[left] != 0) {
                left++;
                continue;
            }
            int right = left + size;
            if (right > memory.length) {
                return -1;
            }
            boolean isAllow = true;
            for (int i = left; i < right; i++) {
                if (memory[i] != 0) {
                    isAllow = false;
                    break;
                }
            }
            if (isAllow) {
                List<Integer> positions = mapper.computeIfAbsent(mID, key -> new ArrayList<>());
                for (int i = left; i < right; i++) {
                    memory[i] = mID;
                    positions.add(i);
                }
                return left;
            }
            left++;
        }
        return -1;
    }

    public int freeMemory(int mID) {
        List<Integer> position = mapper.get(mID);
        int res = 0;
        if (position == null) {
            return res;
        }
        for (Integer i : position) {
            memory[i] = 0;
            res++;
        }
        mapper.put(mID, new ArrayList<>());
        return res;
    }

}


