package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private List<IRenderable> entities;
	private Comparator<IRenderable> compare;
	private static RenderableHolder instance = new RenderableHolder();
	public static double height;
	public static double width;
	
	static {
		loadResource();
	}

	private static void loadResource() {
		height = 620;
		width = 620;
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		compare = new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable a, IRenderable b) {
				return a.getZ() - b.getZ();
			}
		};
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, compare);
		;
	}

	public static RenderableHolder getInstance() {
		return instance;
	}
}