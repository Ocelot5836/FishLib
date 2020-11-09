package io.github.ocelot.sonar.block;

import io.github.ocelot.sonar.common.block.BaseBlock;
import io.github.ocelot.sonar.common.valuecontainer.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestStateBlock extends BaseBlock implements ValueContainer
{
    public TestStateBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void getEntries(World world, BlockPos pos, List<ValueContainerEntry<?>> entries)
    {
        entries.add(new Vector3dValueContainerEntry(new StringTextComponent("test"), "test", new Vec3d(0, 1, 0)));
        entries.add(new Vector3iValueContainerEntry(new StringTextComponent("test"), "test", new Vec3i(0, 1, 0)));
        entries.add(new BlockPosValueContainerEntry(new StringTextComponent("test"), "test", new Vec3i(0, 1, 0)));
        entries.add(new IntValueContainerEntry(new StringTextComponent("test"), "test", 1, 0, 10));
    }

    @Override
    public void readEntries(World world, BlockPos pos, Map<String, ValueContainerEntry<?>> entries)
    {
    }

    @Nullable
    @Override
    public CompoundNBT writeClientValueContainer(World world, BlockPos pos)
    {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("Test", 7);
        return nbt;
    }

    @Override
    public void readClientValueContainer(World world, BlockPos pos, CompoundNBT nbt)
    {
        System.out.println("Received " + nbt.getInt("Test"));
    }
}
